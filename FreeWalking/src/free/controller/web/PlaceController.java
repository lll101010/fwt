package free.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import free.domain.Place;
import free.domain.TourV2;
import free.service.PlaceService;
import free.service.TourService;

@Controller
public class PlaceController {
	@Autowired
	private PlaceService service;
	
	@RequestMapping("placelist.do")
	public String placeList(Model model) {
		List<Place> places = service.findAllPlace();
		model.addAttribute("places", places);
		return "home";
	}
}
