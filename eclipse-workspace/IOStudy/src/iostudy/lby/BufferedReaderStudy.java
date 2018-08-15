package iostudy.lby;

/*
 * 接受键盘输入，并将其写入文件中
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferedReaderStudy {
	public static void main(String[] args) {
		
//		//从键盘读取输入，并在控制台上为输出
//		InputStreamReader reader = new InputStreamReader(System.in);//将InputStream的实例System.in包装为Reader类实例
//		
//		BufferedReader br = new BufferedReader(reader);//将Reader类实例包装为BufferedReader
//		
//		
//		String buffer = null;
//		try {
//			while((buffer = br.readLine() ) != null) {
//				System.out.println(buffer);
//				if(buffer.equals("exit")) {
//					System.exit(0);
//				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				br.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
		//从文件中读取内容，并输出到控制台上及写入新文件
		FileReader fr = null;
		InputStreamReader isr1 = null;
		InputStreamReader isr2 = null;
		OutputStreamWriter osw = null;
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		BufferedWriter bw = null;
		try {
			//fr = new FileReader("水木.txt");
			isr1 = new InputStreamReader(new FileInputStream("水木.txt"), "GBK");
			//new InputStreamR
			br1 = new BufferedReader(isr1);
			String buffer = null;
			while ((buffer = br1.readLine()) != null) {
				System.out.println(buffer);
			}
		} catch (IOException e ) {
			e.printStackTrace();
		}
		finally {
			try {
				br1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//将"水木.txt"的内容copy到"水木copy.txt"中
		
		try {
			isr2 = new InputStreamReader(new FileInputStream("水木.txt"), "GBK");
			br2 = new BufferedReader(isr2);
			osw = new OutputStreamWriter(new FileOutputStream("水木copy.txt"), "GBK");
			bw = new BufferedWriter(osw);
			String buffer = null;
			
			while((buffer = br2.readLine()) != null) {
				bw.write(buffer + "\n");
//				if(buffer.equals("\n")) {
//					bw.write("\n");
//				}
			}
			
		} catch (IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				bw.close();
				br2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}

