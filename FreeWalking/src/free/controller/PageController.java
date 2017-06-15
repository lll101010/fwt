package free.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import free.domain.Place;
import free.domain.TourV2;
import free.service.MemberTourService;
import free.service.PlaceService;
import free.service.TourService;




@Controller
public class PageController {

	@Autowired
	PlaceService placeService;
	@Autowired
	TourService tourService;
	@Autowired
	MemberTourService memtoService;
	
	@RequestMapping("index.do")
	public String mainPage(int id, Model model){
		
		Place p = placeService.findPlaceByPlaceId(id);
		
		try {
			
			String lon = p.getLongitude(); 
			String lat = p.getLatitude(); 
			
			String urlstr = "http://api.openweathermap.org/data/2.5/forecast/daily?lat="+lat+"&lon="+lon+"&cnt=7&APPID=77cd9531534b700e5c09415c07036121";
			URL url = new URL(urlstr);
			BufferedReader bf;
			String line;
			String result = "";

			bf = new BufferedReader(new InputStreamReader(url.openStream()));

			
			while ((line = bf.readLine()) != null) {
				result = result.concat(line);
			}

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
			JSONArray jsonArray = (JSONArray) jsonObj.get("list");


			for (int i = 0; i < jsonArray.size(); i++) {

				JSONObject jsObj = (JSONObject) jsonArray.get(i);
				JSONArray weatherArray = (JSONArray) jsObj.get("weather");
				JSONObject obj = (JSONObject) weatherArray.get(0);
				model.addAttribute("day"+i,getWeather(obj.get("main").toString()));
				
				JSONObject tempObj = (JSONObject) jsObj.get("temp");
				double temp = Double.parseDouble(tempObj.get("day").toString())-273.15;
				model.addAttribute("temp"+i,(int)temp);
				
				Calendar cal = new GregorianCalendar();
			    cal.add(Calendar.DATE, i);
			    String day = ""+(cal.get(Calendar.MONTH) + 1)+" / "+cal.get(Calendar.DAY_OF_MONTH);
			    model.addAttribute("days"+i,day);
			    
			    if(i == 0){
			    	model.addAttribute("humidity",jsObj.get("humidity"));
			    	model.addAttribute("wind",jsObj.get("speed"));
			    }
			}

			bf.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		model.addAttribute("place", p);
		
		return "index";
	}
	
	@RequestMapping("myPage.do")
	public String myPage(String userId, Model model){
		
		
		System.out.println("아이디 내놔라 " + userId);
		List<TourV2> list = tourService.findTourByMemberId(userId);
		model.addAttribute("guideList",list);
		
		List<TourV2> list2 = memtoService.findTourByMemberTour(userId);
		model.addAttribute("tourList",list2);
		
		return "myPage";
	}
	
	private String getWeather(String weather){
		
		switch (weather) {
			case "Thunderstorm":
				return "rain";
			case "Drizzle":
				return "sleet";
			case "Rain":
				return "sleet";
			case "Snow":
				return "snow";
			case "Atmosphere":
				return "fog";
			case "Clear":
				return "clear-day";
			case "Clouds":
				return "cloudy";
			case "Extreme":
				return "wind";
			default:
				return "";
		}
	}
	
}
