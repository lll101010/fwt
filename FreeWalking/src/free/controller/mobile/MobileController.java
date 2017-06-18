package free.controller.mobile;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import free.domain.MemberLocation;
import free.domain.TourV2;
import free.service.MemberLocationService;
import free.service.MemberTourService;
import free.service.PlaceService;
import free.service.TourService;

@Controller
public class MobileController {
	
	
	@Autowired
	PlaceService placeService;
	@Autowired
	TourService tourService;
	@Autowired
	MemberTourService memtoService;
	@Autowired
	MemberLocationService mlService;

	@RequestMapping(value="mobile/myGuideList.do", method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public @ResponseBody String myGuideList(String uid){
		System.out.println("가이드"+uid);
		
		List<TourV2> guideList = tourService.findTourByMemberId(uid);
		Gson gson = new Gson();
		gson.toJson(guideList);
		
		return 	gson.toJson(guideList);
	}
	
	@RequestMapping(value="mobile/LocationList.do", method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public @ResponseBody String LocationList(int tourid){
		System.out.println("투어아이디"+tourid);
		
		List<MemberLocation> locationList = mlService.searchByTourid(tourid);
		Gson gson = new Gson();
		gson.toJson(locationList);
		
		return 	gson.toJson(locationList);
	}
	
	@RequestMapping(value="mobile/myTourList.do", method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public @ResponseBody String myTourList(String uid){
		System.out.println("투어"+uid);
		
		List<TourV2> tourList = memtoService.findTourByMemberTour(uid);
		Gson gson = new Gson();
		gson.toJson(tourList);
		
		return 	gson.toJson(tourList);
	}
	
	@RequestMapping(value="mobile/updateGuideLocation.do",method=RequestMethod.GET)
	public String updateGuideLocation(String uid,String tourid, String lat, String lon){
		System.out.println(uid+","+tourid+","+lat+","+lon);
		MemberLocation ml = new MemberLocation();
		ml.setLatitude(lat);
		ml.setLongitude(lon);
		ml.setMemberid(uid);
		ml.setTourid(Integer.parseInt(tourid));
		mlService.update(ml);
		
		return null;
	}
	
	
	
}
