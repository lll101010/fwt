package free.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import free.domain.File;
import free.domain.MemberTour;
import free.domain.Tour;
import free.domain.TourV2;
import free.service.MemberTourService;
import free.service.PlaceService;
import free.service.TourService;

@Controller
public class TourController {

	@Autowired
	private TourService service;
	@Autowired
	private MemberTourService mToService;
	@Autowired
	private PlaceService pService;

	@RequestMapping("guideApply.do")
	public String guideApply(HttpServletRequest req) throws IOException {

		String imgPath = req.getServletContext().getInitParameter("imgPath");
		int sizeLimit = 1024 * 1024 * 10;
		MultipartRequest multi = new MultipartRequest(req, imgPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());

		String pdate = multi.getParameter("date");
		Date date = Date.valueOf(pdate);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(date);
		startCal.add(Calendar.HOUR, Integer.parseInt(multi.getParameter("time")));
		String startDay = formatter.format(startCal.getTime());

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(date);
		endCal.add(Calendar.HOUR, Integer.parseInt(multi.getParameter("time")) + 2);
		String endDay = formatter.format(endCal.getTime());

		String type = multi.getContentType("image");
		String imagename = multi.getFilesystemName("image");

		File file = new File();

		Tour tour = new Tour();

		tour.setTitle(multi.getParameter("title"));
		tour.setContents(multi.getParameter("contents"));
		tour.setGuideId(multi.getParameter("guideId"));
		tour.setMaxPerson(Integer.parseInt(multi.getParameter("maxPerson")));
		tour.setLanguage(multi.getParameter("language"));
		tour.setStatus("0");
		tour.setPlaceId(Integer.parseInt(multi.getParameter("placeId")));
		tour.setStartDate(startDay);
		tour.setEndDate(endDay);

		if (type == null || imagename == null) {
			type = "image/jpeg";
			imagename = pService.findPlaceByPlaceId(tour.getPlaceId()).getName() + ".jpg";
			file.setName(imagename);
			file.setType(type);
			tour.setFile(file);
		} else {
			file.setName(imagename);
			System.out.println(imagename);
			file.setType(type);
			tour.setFile(file);
		}

		service.registerTour(tour);

		return "redirect:/index.do?id=" + multi.getParameter("placeId");
	}

	@RequestMapping(value = "findApply.ajax", method = RequestMethod.POST)
	public @ResponseBody List<TourV2> findApply(String people, Date firstDate, Date lastDate, int placeId) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(firstDate);
		String startDay = formatter.format(startCal.getTime());

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(lastDate);
		endCal.add(Calendar.HOUR, 24);
		String endDay = formatter.format(endCal.getTime());

		List<TourV2> tours = service.findTourByCondition(startDay, endDay, Integer.parseInt(people), placeId);

		int i = 0;
		for (TourV2 t : tours) {
			String startTime = t.getStartDate().substring(0, 16);
			String endTime = t.getEndDate().substring(0, 16);
			tours.get(i).setStartDate(startTime);
			tours.get(i).setEndDate(endTime);
			i++;

		}
		return tours;

	}

	@RequestMapping("tourApply.do")
	public @ResponseBody String tourApply(String tid, String pcnt, String aid, String hiddenDate) {
		// tid = tourId & aid = memberId & pcnt = peopleCount
		MemberTour mt = new MemberTour();
		mt.setTourId(Integer.parseInt(tid));
		TourV2 t = service.findTourV2ByTourId(Integer.parseInt(tid));
		int capacity = t.getCurrentPerson();
		if (capacity + Integer.parseInt(pcnt) > t.getMaxPerson()) {
			return "over";
		}

		boolean flag = mToService.findMemberTourByAll(aid, Integer.parseInt(tid));

		// 비어있으면 트루
		if (!flag) {
			return "alreadyTour";
		}

		// 내가 그 시간대에 가이드가 있다면 안된다. 시간이랑 가이드 아이디 겹치면 안 되도록만들자
		// aid가

		List<Tour> checkTours = service.findTourByGuideIdStartdate(aid, hiddenDate);
		if (!checkTours.isEmpty()) {
			return "alreadyGuide";
		}

		for (int i = 0; i < Integer.parseInt(pcnt); i++) {
			mToService.registerMemberTour(aid, Integer.parseInt(tid));
		}
		return "ok";
	}

	@RequestMapping(value = "guideApplyCheck.ajax", method = RequestMethod.POST)
	public @ResponseBody String guideApplyCheck(Date date, String time, String guideId) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		Calendar Cal = Calendar.getInstance();
		Cal.setTime(date);
		Cal.add(Calendar.HOUR, Integer.parseInt(time));
		String startDate = formatter.format(Cal.getTime());

		long now = System.currentTimeMillis();

		try {
			java.util.Date currentTime = new java.util.Date(now);
			java.util.Date compareTime = formatter.parse(startDate);
			if (!compareTime.after(currentTime)) {
				return "timeOver";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 혹시 내가 다른 여행에 신청중인가
		boolean timeFlag = true;
		List<Tour> checkTours = service.findTourByCorrectDate(startDate);
		for (Tour t : checkTours) {
			if (!mToService.findMemberTourByAll(guideId, t.getId())) {
				timeFlag = false;
			}
		}

		if (timeFlag == false) {
			return "alreadyTourist";
		}

		List<Tour> t = service.findTourByGuideIdStartdate(guideId, startDate);

		if (!t.isEmpty()) {
			return "false";
		} else {
			return "true";
		}

	}

	@RequestMapping(value = "cancelGuide.do")
	public String cancelGuide(int tourId, String userId, RedirectAttributes redirectAttributes) {
		
		service.removeTour(tourId);
		
		redirectAttributes.addAttribute("userId", userId);
		
		return "redirect:/myPage.do";
	}
	
	@RequestMapping(value = "cancelTour.do")
	public String cancelTour(int tourId, String userId, RedirectAttributes redirectAttributes) {
		
		mToService.removeMemberTour(tourId, userId);
		
		redirectAttributes.addAttribute("userId", userId);
		
		return "redirect:/myPage.do";
	}
}
