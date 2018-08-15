package iostudy.lby;

import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;


/*
 * 字符输入节点流使用
 */
public class FileReaderStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("/Users/liuboying/eclipse-workspace/IOStudy/helloxx.txt");
			int hasCode = 0;
			char[] cbuf = new char[1024];
			
			while((hasCode = fr.read(cbuf))> 0) {
				String s = new String(cbuf, 0, hasCode);
				System.out.println(s);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("1232");

	}
	

}
