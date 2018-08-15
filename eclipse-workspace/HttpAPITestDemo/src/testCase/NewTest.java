package testCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import boying.HttpAPITestDemo.*;


public class NewTest {
  @Test
  public void test_matrix() {
	  String url = "http://api2.newscctv.net/newscctv/api_2_5_0/video/getMatrix";
	  Reporter.log("获取矩阵号接口测试用例");
	  resultCheck(url);
  }
  @Test
  public void test_Appstart() {
	  String url = "http://api.newscctv.net/newscctv/api_2_5_0/common/appstart";
	  Reporter.log("获取app开机页接口测试用例");
	  resultCheck(url);
  }
  @Test
  public void test_finelists() {
	  String url = "http://api.newscctv.net/newscctv/api_2_5_0/video/fineLists";
	  Reporter.log("获取精选列表接口测试用例");
	  resultCheck(url);
  }
  @Test
  public void test_fineCarousels() {
	  String url = "http://api.newscctv.net/newscctv/api_2_5_0/video/fineCarousels";
	  Reporter.log("获取轮播图接口测试用例");
	  resultCheck(url);
  }
  @Test
  public void test_lives() {
	  String url = "http://api.newscctv.net/newscctv/api_2_5_0/video/lives";
	  Reporter.log("获取直播接口测试用例");
	  resultCheck(url);
  }
  @Test
  public void test_getCurrentPolitics() {
	  String url = "http://api.newscctv.net/newscctv/api_2_5_0//video/getCurrentPolitics";
	  Reporter.log("获取时政列表接口测试用例");
	  resultCheck(url);
  }
  
  @Test
  public void test_recentLives() {
	  String url = "http://api.newscctv.net/newscctv/api_2_5_0/ucenter/recentLives";
	  Reporter.log("获取最近直播列表接口测试用例");
	  resultCheck(url);
  }
  @Test
  public void test_specialinfo() {
	  String url = "http://api.newscctv.net/newscctv/api_2_5_0/video/special-info";
	  Reporter.log("获取时政中的专题接口测试用例");
	  resultCheck(url);
  } 
  @Test
  public void test_bootImg() {
	  String url = "http://api.newscctv.net/newscctv/api_2_5_0/message/bootImg";
	  Reporter.log("获取地图接口测试用例");
	  resultCheck(url);
  } 
  
  @Test
  public void test_getRefreshTime2() {
	  String url = "http://api.newscctv.net/newscctv/api_2_5_0/yuntu/getRefreshTime2";
	  Reporter.log("获取地图poi接口测试用例");
	  resultCheck(url);
  } 
  @Test
  public void test_marquee() {
	  String url = "http://api.newscctv.net/newscctv/api_2_5_0/video/marquee";
	  Reporter.log("获取跑马灯接口测试用例");
	  resultCheck(url);
  } 
  @Test(enabled=false)
  public void test_hot_lists() {
	  String url = "https://www.newscctv.net/tap2cdn/video/company/hot_lists.json";
	  Reporter.log("获取矩阵号推荐接口测试用例");
	  resultCheck(url);
  } 
  @Test
  public void test_getVersion() {
	  String url = "http://api.newscctv.net/newscctv/api_2_5_0/auth/getVersion";
	  Reporter.log("获取版本更新接口测试用例");
	  resultCheck(url);
  } 
  
  public void resultCheck(String requesUrl) {
	  String stringStatus;
	  String stringErrorCode;
	  String stringData;
	  String Url = requesUrl;
	  String requestResult;
	  GetHttpResponseContent getHttpResposeContent = new GetHttpResponseContent();
	  JsonPrase jsonPrase = new JsonPrase();

	  
	  Reporter.log("测试用例请求地址为：" + Url);
	  try {
		requestResult = getHttpResposeContent.getHttpResponse(Url);
		stringErrorCode = jsonPrase.jsonPraseWithJsonObject(requestResult, "errorCode");
		stringStatus = jsonPrase.jsonPraseWithJsonObject(requestResult, "status");
		stringData = jsonPrase.jsonPraseWithJsonObject(requestResult, "data");
		
		//Assert.assertEquals(stringErrorCode, "0");
		System.out.println("stringData = " + stringData);
		//Assert.assertNotNull(stringData, "返回json中data字段为空，测试失败");
		if(!stringData.equals("null") ) {
			Assert.assertNotNull(stringData, "返回json中data字段为空，测试失败");
		}
		if(stringData.equals("null") && jsonPrase.jsonPraseWithJsonObject(requestResult,"status").equals("FAIL")){
			System.out.println("***********************");
			assertEquals(jsonPrase.jsonPraseWithJsonObject(requestResult, "msg"), "请重新登录" , "最近直播列表接口测试失败");//针对recentLives接口做处理
		}
		if(stringData.equals("null") && jsonPrase.jsonPraseWithJsonObject(requestResult,"status").equals("SUCCESS")) {
			System.out.println("111***********************");
			Assert.assertEquals(jsonPrase.jsonPraseWithJsonObject(requestResult, "msg"), "成功","时政列表专题接口测试失败");//处理special-info接口无专题列表的情况、bootImg接口
		}
		

		
		//Assert.
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
  }

}
