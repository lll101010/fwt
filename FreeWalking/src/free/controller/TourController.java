package free.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import free.domain.File;
import free.domain.Place;
import free.domain.Tour;
import free.service.PlaceService;
import free.service.TourService;

@Controller
public class TourController {

	@Autowired
	private TourService service;
	
	@RequestMapping("tourApply.do")
	public String guideApply(HttpServletRequest req) throws IOException {
		
		String imgPath = req.getServletContext().getInitParameter("imgPath");
		int sizeLimit = 1024*1024*10;
		MultipartRequest multi = new MultipartRequest(req, imgPath, sizeLimit,"utf-8",new DefaultFileRenamePolicy());
		
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
		
		service.registerTour(tour);
		
		return "redirect:/index.do?id=" + multi.getParameter("placeId");
	}
	
	@RequestMapping(value="findApply.ajax",method=RequestMethod.POST)
	public @ResponseBody List<Tour> findApply(String people, Date firstDate, Date lastDate, int placeId) {
		System.out.println("��û�ο�" + people);
		System.out.println("���۳� " +firstDate);
		System.out.println("����" + lastDate);
		System.out.println("�� ��ġ��" + placeId);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(firstDate);
		String startDay = formatter.format(startCal.getTime());
		
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(lastDate);
		endCal.add(Calendar.HOUR, 24);
		String endDay = formatter.format(endCal.getTime());
		
		List<Tour> tours = service.findTourByCondition(startDay, endDay, Integer.parseInt(people), placeId);
		
		System.out.println(tours.size());
		int i = 0;
		for(Tour t : tours) {
			String startTime = t.getStartDate().substring(0,16);
			String endTime = t.getEndDate().substring(0,16);
			tours.get(i).setStartDate(startTime);
			tours.get(i).setEndDate(endTime);
			System.out.println(tours.get(i).toString());
			i++;
		}
		
		
		
		return tours;
	}
	
	
	
}
