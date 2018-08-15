package boying.HttpAPITestDemo;
import org.json.JSONObject;

public class GetHttpAPITestDemo {
	
	/*
	 * 以下main函数实现从url列表文件中获取url
	 * 建立http连接后获取请求返回的输入状态码，并将请求的url、返回的请求内容、请求码、测试结果写入到excel中
	 * 
	 */
	public static void main(String[] args) {
		//GetHttpResponseContent getHttpResponseContent = new GetHttpResponseContent();
		String filename = "/Users/liuboying/eclipse-workspace/HttpAPITestDemo/result/testResult.xls";
		String paramfile = "/Users/liuboying/eclipse-workspace/HttpAPITestDemo/param/urllist.txt";
		String excelinfo_dir = "/Users/liuboying/eclipse-workspace/HttpAPITestDemo/execelinfo";
	}
	
	
	
	
	
/*
 * 以下main函数实现获取请求中的json数据
 */

//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		GetHttpResponseContent getHttpResponseContent = new GetHttpResponseContent();
//		String url = "http://api2.newscctv.net/newscctv/api_2_5_0/video/getMatrix";
//		getHttpResponseContent.getHttpResponse(url);
//		
//		//获取key为data的数据
//		String jsonValueData = "";
//		JsonPrase jsonPrase = new JsonPrase();
//		jsonValueData = jsonPrase.jsonPraseWithJsonObject(getHttpResponseContent.getHttpResponse(url), "data");
//		System.out.println("jasonValueDate = " + jsonValueData);
//		
//		//获取data数组中第1个数据
//		String jsonValue1 = "";
//		jsonValue1 = jsonPrase.jsonParseWithJSONArray(jsonValueData, 0);
//		System.out.println("jsonValue = " + jsonValue1);
//		
//		//获取data数组中第一个数据的key为“deptName”对应的值
//		
//		String deptName = "";
////		String img = "";
////		String deptId = "";
////		String count = "";
////		String deptImageUrl = "";
//		
//		JSONObject jsonObject1DeptName = new JSONObject(jsonValue1);
//		deptName = jsonObject1DeptName.getString("deptName");
//		System.out.println("deptName = " + deptName);
//		System.out.println("img = " + jsonObject1DeptName.getString("img"));
//		System.out.println("deptId = " + jsonObject1DeptName.getString("deptId"));
//		System.out.println("count = " + jsonObject1DeptName.getString("count"));
//		System.out.println("deptImgurl = " + jsonObject1DeptName.getString("deptImgurl"));
//
//	}

}
