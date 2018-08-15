package jsonPrase;
import java.awt.List;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.JSONStringer;
import org.json.JSONTokener;
import JSONObjectStudy.*;

public class jsonParse {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		JSONObjectStudy study = new JSONObjectStudy();

//		System.out.println(study.creatJsonWeather());//测试创建不带数组的json
//		try {
//			study.creatJsonBook();//测试创建带数组的json
//		} catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		try {
//			study.parseBooks(study.creatJsonBook());//测试解析带数组的json
//		} catch (JSONException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		} catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
		
		//study.arrayListToJsonArray();//测试ArrayList转化为JSONArray格式
		
		study.objectToJsonArray();
		
		
		//使用string参数构造JSONObject对象
//		String s = "{\"address\":\"Beijing\",\"name\":\"test1\",\"id\":1,\"age\":21}";
//		try {
//			System.out.println(new JSONObject(s));
//		} catch (JSONException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println(JSONObject.quote(s));//将string类型转化为JSON字符串
//		
//		//System.out.println(createJsonString("name","liuboying"));
//		System.out.println(createJsonByJSONObject());
//		System.out.println(createJsonByJSONString());
//		try {
//			parseJSONWithJSONObject(createJsonByJSONObject());
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	//生成json数据(JSONObject类）
	public static String createJsonByJSONObject() {
		JSONObject jsonObject = new JSONObject();//创建无数据的JSONObject对象
		try {
			jsonObject.put("id", 1);//添加JSONObject对象的key/value对
			jsonObject.put("name", "test1");
			jsonObject.put("age", 21);
			jsonObject.put("address","Beijing");
			jsonObject.put("noname", JSONObject.NULL);//将json中的key赋值为null的做法
			//jsonObject.put("noname", null);
			jsonObject.accumulate("name", "test2");//向name中追加value
		}
		catch(Exception e) {
			
		}
		
		return jsonObject.toString();
		
	}
	
	//生成json数据(JSONString类）
	public static String createJsonByJSONString() {
		JSONStringer jsonStringer = new JSONStringer();
		try {
			jsonStringer.object();
			jsonStringer.key("id");
			jsonStringer.value(1);
			jsonStringer.key("name");
			jsonStringer.value("test1");
			jsonStringer.key("age");
			jsonStringer.value(20);
			jsonStringer.key("address");
			jsonStringer.value("Beijing");
			
			
//			JSONStringer jsonStringer1 = new JSONStringer();
//			try {
//				
//				jsonStringer1.object();
//				jsonStringer1.key("brother");
//				jsonStringer1.value("benben");
//				jsonStringer1.endObject();
//			}catch(Exception e) {
//				
//			}
//			
//			ArrayList<JSONStringer> jsonStringerArraylist = new ArrayList<JSONStringer>();
//			jsonStringerArraylist.add(jsonStringer1);
//			jsonStringer.key("family");
//			//jsonStringer.value(jsonStringer1);
//			jsonStringer.value(jsonStringerArraylist);
//			
//			
//			JSONObject jsonObject1 = new JSONObject();
//			try {
//				jsonObject1.put("school", "nanchangerzhogn");
//				jsonObject1.put("teacher", "Teacher Li");
//			}catch(Exception e) {
//				
//			}
//			ArrayList<JSONObject> jsonObjectsList = new ArrayList<JSONObject>();
//			jsonObjectsList.add(jsonObject1);
//			//List<>
//			jsonStringer.key("other");
//			jsonStringer.value(jsonObjectsList);
//			jsonStringer.endObject();

		
		}
		catch(Exception e) {
			
		}
		
		
		return jsonStringer.toString();
	}
	
	//解析JSON字符串，不带数组
	public static void parseJSONWithJSONObject(String json) throws JSONException {
		int id;
		String name;
		String address;
		String age;
		JSONObject jsonObject = new JSONObject(json);
		//id = jsonObject.getString("id");
		id = jsonObject.getInt("id");
		//id = Double.valueOf(jsonObject.getString("id"));
		name = jsonObject.getString("name");
		address = jsonObject.getString("address");
		age = jsonObject.getString("age");
		System.out.println("id = " + id + "\t" + "name = " + name + "\t" + "age = " + age + "\t" + "address = " + address);
	}
	
	public static void parseJSONWithJSONObject2(String json) throws JSONException{
		JSONObject jsonObject = new JSONObject(json);
		int id = jsonObject.getInt("id");
		String name = jsonObject.getString("name");
		int age = jsonObject.getInt("age");
		String address = jsonObject.getString("address");
		JSONArray jsonArray = new JSONArray();
		jsonArray = jsonObject.getJSONArray("family");
		
		
	}
	

}
