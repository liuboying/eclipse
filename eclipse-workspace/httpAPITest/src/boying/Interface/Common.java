package boying.Interface;

/*
 * json解析
 */
import org.json.*;
public class Common {

	public String getJsonValue(String jsonString, String jsonKey) {
		String jsonValue = "";
		if((jsonString == null) || jsonString.trim().length() < 1){
			return null;
		}
		try {
			JSONObject obj1 = new JSONObject(jsonString);
			jsonValue = obj1.getString(jsonKey);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonValue;
	}
	
}
