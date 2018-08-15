package boying.Interface;

/*
 * 请求接口封装，根据传入city id组装不同的请求地址，进行请求，并返回结果数据
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class getCityWeather {

	private String url = "";
	
	public String getUrl() {
		return this.url;
	}
	
	public String getHttpResponse(String cityCode) throws IOException{
		String line = "";
		String httpResult = "";
		url = "http://www.weather.com.cn/data/cityinfo/" + cityCode + ".html";
		try {
			//HttpURLConnection connection = URLConnetcion.getConnection(url);
			URL urlConnection = new URL(url);
			
			//打开连接
			HttpURLConnection connection = (HttpURLConnection)urlConnection.openConnection();
			//DataOutputStream out = null;
			
			//设置连接参数
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			
			//设置请求参数
			connection.setRequestProperty("Content-Type", "text/html");
			connection.setRequestProperty("Charset", "utf-8");
			connection.setRequestProperty("Accep-Charset", "utf-8");
				
			//建立实际的链接
			connection.connect();//当调用connection.getInputStream()时会自动调用该函数，此处无须调用

			//读取网页内容
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			while((line = reader.readLine()) != null) {
				httpResult = httpResult + line.toString();
			}
			reader.close();
//			System.out.println(connection.toString());
//			String s = connection.getRequestMethod();
//			System.out.println(connection.getRequestMethod());
//			System.out.println("ResponseCode is " + connection.getResponseCode());
//			System.out.println("ResponseMessage is " + connection.getResponseMessage());
//			//System.out.println("ResponseType is " + connection.getRequestProperty("Content-Type"));
			
			
			//断开链接
			connection.disconnect();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(httpResult);
		
		return httpResult;//返回接口的json串
	}
}
