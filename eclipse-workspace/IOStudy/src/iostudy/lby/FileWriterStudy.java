package iostudy.lby;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

/*
 * 字符输出节点流使用
 */
public class FileWriterStudy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		

		File file = new File("testforfilewriter.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		
		//读取原文件的内容
		FileReader fr = new FileReader(file);
		char[] cbuf = new char[1024];
		int hasCode = 0;
		StringBuffer sb = new StringBuffer();
		while((hasCode = fr.read(cbuf)) > 0) {
			sb.append(cbuf);
			sb.append("\n");
			System.out.println(sb);
		}
		
		
		//将原文件及内容写入到原文件
		FileWriter fw = new FileWriter(file);
		String s = "welcome to China!";
		//StringBuffer sb1 = new StringBuffer();
		sb = sb.append(s);
		System.out.println(sb);
		fw.write(sb.toString());
		fw.close();
	}

}
