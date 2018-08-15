package boying.Interface;

import java.io.IOException;

public class MainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getCityWeather cityWeather = new getCityWeather();
		Common jsonPrase = new Common();
		String json;
		String jsonValue = "";
		String weatherInfo = "";
		try {
			json = cityWeather.getHttpResponse("101010100");
			System.out.println(json);
			weatherInfo = jsonPrase.getJsonValue(json,"weatherinfo");
			System.out.println(weatherInfo);
			jsonValue = jsonPrase.getJsonValue(weatherInfo, "city");
			System.out.println(jsonValue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
