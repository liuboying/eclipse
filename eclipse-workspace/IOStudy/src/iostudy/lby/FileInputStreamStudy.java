package iostudy.lby;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;



/*
 * 字节输入节点流使用
 */
public class FileInputStreamStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("/Users/liuboying/eclipse-workspace/IOStudy/src/iostudy/lby/FileInputStreamStudy.java");
			
			byte[] bbuf = new byte[2048];
			int hasCode = 0;
			System.out.println(hasCode);
			while((hasCode = fis.read(bbuf)) > 0) {
				System.out.println(new String(bbuf, 0, hasCode));
				//hasCode = fis.read(bbuf);
				String s = new String(bbuf);
				//String s1 = "12222";
				//System.out.println(s);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//将FileInputStreamStudy.java的内容读出来，并写入到新的newFileInputStreamStudy.txt中
	}

}
