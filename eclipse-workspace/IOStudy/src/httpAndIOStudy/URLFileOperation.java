package httpAndIOStudy;

import java.awt.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/*
 * 从文件中依次读取URL地址，并存储到ArraryList中
 * 文件中按一行一个URL的形式存储
 */

public class URLFileOperation {
	
	public static ArrayList<String> getURLList(String fileName) throws IOException{
		ArrayList<String> URLList = new ArrayList<String>();
		String buffer = null;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			while((buffer = br.readLine()) != null) {
				URLList.add(buffer);
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return URLList;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String fileName = "URLList.txt";
		ArrayList<String> urlList = new ArrayList<>();
		urlList = getURLList(fileName);
		
		int loopCount  = urlList.size();
		int index = 0;
		while(loopCount != 0) {
			System.out.println(urlList.get(index) + "\t");
			System.out.println(HttpRequest.getResponseCode(urlList.get(index)));
			index ++;
			loopCount --;
		}
		
		
	}

}
