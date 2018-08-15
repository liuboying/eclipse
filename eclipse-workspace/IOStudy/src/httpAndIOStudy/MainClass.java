package httpAndIOStudy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import jxl.Workbook;
import jxl.write.*;

public class MainClass {
	
//	public void static getPath() {
//		 File f2 = new File(this.getClass().getResource("").getPath());
//        System.out.println(f2);
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resourcePath=System.getProperty("user.dir");//获取当前工程所在路径
		System.out.println(resourcePath);
		
		String fileName1 = resourcePath + "//URL//URLList.txt";
		String fileName2 = resourcePath + "//result//测试结果.xls";
		URLFileOperation urlFileOpertion = new URLFileOperation();
		ArrayList<String> urlList = new ArrayList<>();
		HttpRequest httpRequest = new HttpRequest();
		WritableSheet ws = null;
		//MainClass.getPath();
		
		
		ExcellOperation excelOperation = new ExcellOperation();
		
		try {
			urlList = urlFileOpertion.getURLList(fileName1);
			int index = 0;
			int loopCount = urlList.size();
			System.out.println("********" + loopCount);
			String result;
			
			//初始化测试结果表格
			excelOperation.CreateWorkbook(fileName2);
			
			
			//File file = new File("测试结果.xls")
			//Workbook rs = Workbook.getWorkbook(file)
			while(loopCount >  0) {
				//System.out.println(loopCount);
				try {
					result = null;
					//httpRequest.getResponseCode(urlList.get(index));
					if(httpRequest.getResponseCode(urlList.get(index)) == 200) {
						result = "pass";
					}else {
						result = "failed";
					}
					excelOperation.WriteCell(fileName2, urlList.get(index), httpRequest.getResponseCode(urlList.get(index)), result, index+1);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				index ++;
				loopCount --;
				
			}
			System.out.println("test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
