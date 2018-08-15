package iostudy.lby;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 字符输出节点流使用。
 * 
 */

public class FileOutputStreamStudy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String s = "welcome to Beijing";
		byte[] bbuf = new byte[1024];
		bbuf = s.getBytes();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("testforfilewriter.txt"));
			fos.write(bbuf);//write函数会将原文件的内容清空后再写入
			//fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fos != null) {
				fos.close();
			}
		}
	}

}
