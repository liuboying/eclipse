package boying.Interface;

/*
 * http请求头封装
 */

import java.net.HttpURLConnection;
import java.net.URL;
public class URLConnetcion {
	
//	private String requestURL;
//	
//	public String getURL() {
//		return requestURL;
//	}

	public static HttpURLConnection getConnection(String url) {
		HttpURLConnection connection = null;
		try {
			//打开和URL之间的连接
			URL postUrl = new URL(url);
			connection = (HttpURLConnection)postUrl.openConnection();
			//设置通用的请求属性
			connection.setDoInput(true);
			//connection.setDoOutput(true);//解决报错Server returned HTTP response code: 405，此处会将请求的method强制变成POST
			//connection.setRequestMethod("HEAD");//解决报错Server returned HTTP response code: 405，但返回消息体为空
			connection.setRequestMethod("GET");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "text/html");
			connection.setRequestProperty("Content-Length", "0");
			connection.setRequestProperty("Charset", "utf-8");
			connection.setRequestProperty("Accep-Charset", "utf-8");
			//connection.setRequestProperty("User-Agent", "Mozilla/4.0(compatible;MSIE 5.0;Windows NT;DigExt");
			//connection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
