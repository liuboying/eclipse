package lby.testcase;

import org.testng.annotations.Test;

import boying.Interface.Common;
import boying.Interface.URLConnetcion;
import boying.Interface.getCityWeather;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

public class WeatherTestCase {
  @Test(enabled = false)
  public void test_Beijing() {
	  getCityWeather cityWeather = new getCityWeather();
		 String exp_city = "北京";
		 String actual_city;
		 String weather_result;
		 String cityCode = "101010100";
		 Reporter.log("正常用例：获取" + exp_city + "天气成功"); 
		 try {
			weather_result = cityWeather.getHttpResponse(cityCode);
			 Reporter.log("请求地址为：" + cityWeather.getUrl());
			Reporter.log("返回的结果为：" + weather_result);
			actual_city = new Common().getJsonValue((new Common().getJsonValue(weather_result, "weatherinfo")), "city");
			assertEquals(actual_city, exp_city);
			Reporter.log("实际城市为：" + actual_city + "，期望城市为：" + exp_city + ",测试通过");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  @Test(enabled = false)
  public void test_Shenzhen() {
	  String exp_city = "深圳";
	  String actual_city;
	  String cityCode = "101280601";
	  getCityWeather cityWeather = new getCityWeather();
	  String weather_result;
	  Reporter.log("正常用例：获取" + exp_city + "天气成功");
	  try {
		  weather_result = cityWeather.getHttpResponse(cityCode);
		  Reporter.log("请求地址为：" + cityWeather.getUrl());
		  Reporter.log("返回的结果为：" + weather_result);
		  actual_city = new Common().getJsonValue((new Common().getJsonValue(weather_result, "weatherinfo")), "city");
		  assertEquals(actual_city, exp_city);
		  Reporter.log("实际城市为：" + actual_city + "，期望城市为：" + exp_city + ",测试通过");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  @Test(groups = "BaseCase")
  public void test_beijing1() {
	  String stringExp_city = "北京";
	  String stringCityCode = "101010100";
	  resultCheck(stringExp_city, stringCityCode);
	  
  }
  @Test(groups = "BaseCase")
  public void test_shanghai() {
	  String stringExp_city = "上海";
	  String stringCityCode = "101020100";
	  resultCheck(stringExp_city, stringCityCode);
  }
  @Test (groups = "BaseCase")
  public void test_shenzhen2() {
	  String stringExp_city = "深圳";
	  String stringCityCode = "101280601";
	  resultCheck(stringExp_city, stringCityCode);
  }
  
  //@BeforeMethod
  public void resultCheck(String stringExp_city, String stringCityCode) {
	  String exp_city = stringExp_city;
	  String cityCode = stringCityCode;
	  String act_city;
	  getCityWeather cityWeather = new getCityWeather();
	  String weather_result;
	  Reporter.log("正常用例：获取" + exp_city + "天气测试用例！");
	  try {
		  weather_result = cityWeather.getHttpResponse(cityCode);
		  Reporter.log("请求地址为： " +  cityWeather.getUrl());
		  Reporter.log("请求天气的预期城市为：" + exp_city);
		  act_city = new Common().getJsonValue(new Common().getJsonValue(weather_result, "weatherinfo"),"city");
		  Reporter.log("返回天气的实际城市为：" + act_city);
		  Assert.assertEquals(act_city, exp_city);

	  }catch(IOException e) {
		  e.printStackTrace();
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	 getCityWeather cityWeather;
	 String exp_city;
	 String actula_city;
	 
  }
  
  
  
  

}
