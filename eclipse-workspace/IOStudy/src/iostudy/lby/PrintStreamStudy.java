package iostudy.lby;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.FileNotFoundException;
//import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PrintStreamStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintStream ps = null;
		FileReader fr1 = null;
		FileReader fr2 = null;
		int hasRead = 0;
		
		//写文件
		try {
			FileOutputStream fos = new FileOutputStream("newtext.txt");
			ps = new PrintStream(fos);
			ps.append('a');
			ps.print('b');
			ps.println("窗前明月光");
			ps.println("I like you");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ps.close();
		}
		//读文件并在控制台输出
		try {
			fr1 = new FileReader("newtext.txt");
			//hasRead = fr.read();
			
			while((hasRead = fr1.read()) != -1) {
				//判断原文件是否读到回车符，是的话，同样的在控制台输出回车符
				if(Character.toString((char)hasRead) == "\n") {
					System.out.print("\n");
				}
				System.out.print((char)hasRead);//输出原文件内容，由于read()方法返回的为读取的字符的ASCII码，所以打印是需要强制类型转换成char型输出
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭输入流
		finally {
			try {
				fr1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//将读取的内容写入另外一个文件
		PrintWriter pw = null;
		FileWriter fw = null;

		
		try {
			fr2 = new FileReader("newtext.txt");
			fw = new FileWriter("newtextcopy.txt");
			pw = new PrintWriter(fw);
			int hasCode2 = 0;
			while((hasCode2 = fr2.read()) != -1) {
				pw.append((char)hasCode2);
			}
			fw.write("Im FilwWriter");
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fr2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.close();
		}
		
		
		
		
	}

}
