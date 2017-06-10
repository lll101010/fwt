package testapi;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

public class WeatherTest1 {

	// http://api.openweathermap.org/data/2.5/forecast/daily?lat=37.56826&lon=126.977829&cnt=6&APPID=77cd9531534b700e5c09415c07036121

	@Test
	public void test() {
		try {
			// 서울시청의 위도와 경도
			String lon = "126.977948"; // 경도
			String lat = "37.566386"; // 위도

			// OpenAPI call하는 URL
			String urlstr = "http://api.openweathermap.org/data/2.5/forecast/daily?lat=37.56826&lon=126.977829&cnt=6&APPID=77cd9531534b700e5c09415c07036121";
			URL url = new URL(urlstr);
			BufferedReader bf;
			String line;
			String result = "";

			// 날씨 정보를 받아온다.
			bf = new BufferedReader(new InputStreamReader(url.openStream()));

			// 버퍼에 있는 정보를 문자열로 변환.
			while ((line = bf.readLine()) != null) {
				result = result.concat(line);
				// System.out.println(line);
			}

			// 문자열을 JSON으로 파싱
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
			JSONArray jsonArray = (JSONArray) jsonObj.get("list");

			// 갯수
			System.out.println("리스트 갯수 : " + jsonArray.size());

			for (int i = 0; i < jsonArray.size(); i++) {

				JSONObject jsObj = (JSONObject) jsonArray.get(i);
				JSONArray weatherArray = (JSONArray) jsObj.get("weather");
				JSONObject obj = (JSONObject) weatherArray.get(0);
				System.out.println("날씨 : " + obj.get("main"));
				
				JSONObject jsObj2 = (JSONObject) jsonArray.get(i);
				JSONObject tempObj = (JSONObject) jsObj2.get("temp");
				double temp = Double.parseDouble(tempObj.get("day").toString())-273.15;
				System.out.printf("온도 : %.2f\n",temp);
				
				System.out.println("습도"+jsObj.get("humidity"));

			}

		

			/*
			 //날씨 출력 JSONArray weatherArray = (JSONArray)
			 jsonObj.get("weather"); JSONObject obj = (JSONObject)
			 weatherArray.get(0); System.out.println("날씨 : "+obj.get("main"));
			 * 
			 //온도 출력(절대온도라서 변환 필요)
			 JSONObject mainArray = (JSONObject)
			 jsonObj.get("main"); double ktemp =
			 Double.parseDouble(mainArray.get("temp").toString());
			 double temp = ktemp-273.15; System.out.printf("온도 : %.2f\n",temp);
			 */

			bf.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
