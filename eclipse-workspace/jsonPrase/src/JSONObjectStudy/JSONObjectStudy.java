package JSONObjectStudy;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONObjectStudy {
	public static String creatJsonWeather() {
		JSONObject jsonObject1 = new JSONObject();//最外层的Object对象
		JSONObject jsonObject2 = new JSONObject();//次外层的Object对象
		try {
			jsonObject2.put("city" , "北京");
			jsonObject2.put("cityid", 101010100);
			jsonObject2.put("temp1", "18°C");
			jsonObject2.put("temp2", "31°C");
			jsonObject2.put("weather","cloud");
			jsonObject2.put("img1", "n1.gif");
			jsonObject2.put("img2", "d2.gif");
			jsonObject2.put("ptime", "18:00");
			
		}catch(Exception e) {
			
		}
		try {
			jsonObject1.put("weatherinfo", jsonObject2);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject1.toString();
	}
	
	//创建Book
	public static String creatJsonBook() throws Exception {
		JSONObject json = new JSONObject();//外层object
		JSONObject json1 = new JSONObject();//数组内object
		JSONObject json2 = new JSONObject();//数组内object
		JSONObject json3 = new JSONObject();
		JSONObject json4 = new JSONObject();
		JSONArray personalInfo = new JSONArray();
		//JSONObject books = new JSONObject();
		JSONArray books = new JSONArray();
		json1.put("name", "iOS开发");
		json1.put("author", "zhangssan");
		json1.put("year", "2018.10");
		json2.put("name", "android开发");
		json2.put("author", "lisi");
		json2.put("year", "2017");
		books.put(json1);
		books.put(json2);
		json.put("books", books);
		json3.put("gender", "femle");
		json4.put("age", 25);
		personalInfo.put(json3);
		personalInfo.put(json4);
		json.put("personalInfo", personalInfo);
		
		json.put("id", 1);
		json.put("username","liuboying");
		System.out.println(json.toString());
		//System.out.println("//////" + personalInfo.getString(0));//获取数组中的元素，注意返回的是key:value对
		
		return json.toString();
	}
	//解析weather
	
	public  void parseBooks(String s) throws JSONException {
		//String s = json.toString();
		JSONObject json = new JSONObject(s);
		
		int id = json.getInt("id");
		String username = json.getString("username");
		System.out.println("id = " + id + "\tusername = " + username);
		JSONArray jsonArray1 = json.getJSONArray("books");
		JSONArray jsonArray2 = json.getJSONArray("personalInfo");
		System.out.println("books为:" + jsonArray1);
		System.out.println("personalInfo为:" + jsonArray2);
		
		//解析json中数组中的元素
		String book1 = jsonArray1.getString(0);
		//JSONObject jsonBook1 = new JSONObject(book1);
		JSONObject jsonBook1 = jsonArray1.getJSONObject(0);
		String bookName1 = jsonBook1.getString("name");
		String bookAuthor1 = jsonBook1.getString("author");
		String bookYear1 = jsonBook1.getString("year");
		System.out.println("book1的详细信息为：" + bookName1 + "\t" + bookAuthor1 + "\t" + bookYear1);
		
		System.out.println("book1 = " + book1);
		
		JSONObject jsonBook2 = new JSONObject(jsonArray1.get(1).toString());
		String bookName2 = jsonBook2.getString("name");
		String bookAuthor2 = jsonBook2.getString("author");
		String bookYear2 = jsonBook2.getString("year");
		System.out.println("book2的详细信息为：" + bookName2 + "\t" + bookAuthor2 + "\t" + bookYear2);
		
		
		
		
	}
	public void arrayListToJsonArray() {
		ArrayList<String> list=new ArrayList<String>();
        list.add("java");
        list.add("android");
        //JSONArray jsonarray = JSONArray.toJSONObject(list);
        JSONArray jsonarray= new JSONArray(list);
        System.out.println(jsonarray);
	}
	public void objectToJsonArray() throws JSONException {
		User user1 = new User();
		//User user2 = new User();
		user1.setAge(25);
		user1.setName("test1");
		user1.setGender("female");
		
		String[] s = {"name","gender","age"};
		JSONObject json = new JSONObject(user1,s); 
//		JSONObject json = new JSONObject(object, names)
		System.out.println(json);
		
//		ArrayList<User> arrayListUser = new ArrayList<>();
//		arrayListUser.add(user1);
//		//arrayListUser.add(user2);
//		
//		//JSONArray jsonArray = new JSONArray();
//		//jsonArray.put("name",user1.getName());
//		//jsonArray.put
//		JSONObject jsonObejct = new JSONObject();
//		jsonObejct.put("name",user1.getName());
//		jsonObejct.put("gender",user1.getGender());
//		
//		
		//JSONObject jsonObject = new JSONObject(arrayListUser);
		
	// System.out.println(jsonArray);
		
	}

}
