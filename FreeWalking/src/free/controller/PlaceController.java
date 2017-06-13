package free.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import free.domain.Place;
import free.service.PlaceService;
import free.service.TourService;

@Controller
public class PlaceController {
	@Autowired
	private PlaceService service;
	@Autowired
	private TourService tService;
	
	@RequestMapping("placelist.do")
	public String placeList(Model model) {
		List<Place> places = service.findAllPlace();
		model.addAttribute("places", places);
		
		// 오늘 그 지역의 Tour의 갯수 받아오자
		
	
		
		return "home";
	}
}
