package iostudy.lby;

/*
 * StringReader和StringWriter的操作对象为字符串
 */

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method 

		
		String src ="登鹳雀楼\n" 
				+ "白日依山尽\n"
				+ "黄河入海流\n"
				+ "欲穷千里目\n"
				+ "更上一层楼\n" ;
		
		StringReader sr = new StringReader(src);
		int hasCode = 0;
		try {
			while((hasCode = sr.read()) != -1) {
				System.out.print((char)hasCode);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sr.close();
		}
		
		//StringWriter
		StringWriter sw = new StringWriter(30);
		sw.write("咏鹅\n");
		sw.write("鹅鹅鹅\n");
		sw.write("曲项向天歌\n");
		sw.write("白毛浮绿水\n");
		sw.write("红掌拨清波\n");
		System.out.println(sw.toString());
		
	}

}
