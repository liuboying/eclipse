package boying.HttpAPITestDemo;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;


/*
 * 解析json
 */

public class JsonPrase {

	public String jsonPraseWithJsonObject(String jsonString, String jsonKey) {
		
		String jsonValue = "";
		if((jsonString == null) || (jsonString.trim().length() < 1)) {
			return null;
		}
		
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			jsonValue = jsonObject.getString(jsonKey);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonValue;
	}
	public String jsonParseWithJSONArray(String jsonString, int jsonArrayIndex) {
		String jsonValue = "";
		
		try {
			JSONArray jsonArray = new JSONArray(jsonString);
			jsonValue = jsonArray.getString(jsonArrayIndex);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonValue;
	}
}
