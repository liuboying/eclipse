package boying.HttpAPITestDemo;

//import bsh.org.objectweb.asm.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import jxl.write.Label;

public class Excel {

	
	/*
	 * 将制定内容写入制定的单元格中
	 * @param ws 待写入的工作簿
	 * @param intRow 单元格的行号
	 * @param intColumn 单元格的列号
	 * @param stringContent 写入的内容
	 */
	public void writeCell(WritableSheet ws, int intRow, int intColumn, String stringContent) {
		Label label = new Label(intColumn, intRow, stringContent);
		try {
			ws.addCell(label);//将单元格写入表格中
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> getExcelInfoFromFile(File file){
		List<String> excelInfo = new ArrayList<>();
		String temp;
		
		try {
			FileInputStream file_in = new FileInputStream(file);
			BufferedReader buffer_in = new BufferedReader(new InputStreamReader(file_in));
			temp = buffer_in.readLine();
			if(temp != null) {
				excelInfo.add(temp);
				temp = buffer_in.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(excelInfo);
		
		return excelInfo;
		
	}
}
