package httpAndIOStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
//import java.net.URI;
import java.net.URL;

public class HttpRequest {
	
	static int i_responseCode;
	
	
	
	/*
	 * 获取http返回的状态码
	 */
	public static int getResponseCode(String url) throws Exception{
		//String s = "http://api2.newscctv.net/newscctv/api_2_5_0/video/getMatrix";
		String s = url;
		URL httpURL = new URL(s);//创建URL对象
		
		HttpURLConnection httpURLConnection = (HttpURLConnection)httpURL.openConnection();//创建HttpURLConnetion对象
		httpURLConnection.connect();//连接http服务器
		i_responseCode = httpURLConnection.getResponseCode();
		httpURLConnection.disconnect();//断开http链接
		return i_responseCode;	
	}
	
	/*
	 * 将返回数据写入到本地文件
	 */
	public static void writeResponseContent(String URL) throws MalformedURLException, IOException {
		URL httpURL = new URL(URL);
		HttpURLConnection httpURLConnetion = (HttpURLConnection)httpURL.openConnection();
		httpURLConnetion.connect();
		
		String buffer = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnetion.getInputStream(), "UTF-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ResponseContent.txt")));
		while((buffer = br.readLine()) != null) {
			bw.write(buffer);
			bw.newLine();
		}
		bw.close();
		br.close();
	}
	
	public static void main (String[] agrs) throws Exception {
		String URL = "http://api2.newscctv.net/newscctv/api_2_5_0/video/getMatrix";
		//connetToHttp(URL);
		System.out.println(getResponseCode(URL));//打印返回状态码
		writeResponseContent(URL);
	}
	
}
