package boying.HttpAPITestDemo;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLConnection;

public class GetHttpResponseContent {
	
	public String getHttpResponse(String url) throws Exception {
		String httpResponse = "";
		String line = null;
		
		
		//利用传入的url创建URL对象
		URL httpUrl = new URL(url);
		
		//打开连接
		HttpURLConnection httpUrlConnetion = (HttpURLConnection)httpUrl.openConnection();
		
		//配置连接参数
		httpUrlConnetion.setRequestMethod("GET");
//		httpUrlConnetion.setDoInput(true);
//		httpUrlConnetion.setUseCaches(false);
//		httpUrlConnetion.setInstanceFollowRedirects(true);
//		
//		
//		//配置请求参数
//		httpUrlConnetion.setRequestProperty("Accept", "text/html");
//		httpUrlConnetion.addRequestProperty("Accept", "application/xhtml+xml");
//		httpUrlConnetion.addRequestProperty("Accept", "application/xml");
//		httpUrlConnetion.addRequestProperty("Accept", "application/xml");
//		httpUrlConnetion.setRequestProperty("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36" );
//		httpUrlConnetion.setRequestProperty("Accept-Encoding", "gzip");
//		httpUrlConnetion.addRequestProperty("Accept-Encoding","deflate");
//		httpUrlConnetion.setRequestProperty("Accept-Language", "Zh-CN");
//		httpUrlConnetion.setRequestProperty("Charset", "utf-8");
//		httpUrlConnetion.setRequestProperty("Accept-Charset", "utf-8");
		
		httpUrlConnetion.connect();//连接远程服务器
		
		BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConnetion.getInputStream()));
		StringBuffer bs = new StringBuffer();
		System.out.println("返回状态码为" + httpUrlConnetion.getResponseCode());
		
		while((line = in.readLine()) != null ) {
			httpResponse = httpResponse + line.toString();
			//bs.append(line).append("\n");
		}
		in.close();//关闭输入流
		System.out.println(httpResponse);
		//System.out.println(bs.toString());
		httpUrlConnetion.disconnect();//关闭远程服务器链接
		
		return httpResponse;
		
		
		
	}

}
