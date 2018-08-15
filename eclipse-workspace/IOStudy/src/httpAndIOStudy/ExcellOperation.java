package httpAndIOStudy;
import jxl.write.WritableWorkbook;
import jxl.write.WritableSheet;
import jxl.write.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcellOperation {
	
	/*
	 * 创建工作簿，写sheet名称、工作表表头等信息
	 * @param fileName:创建的工作簿文件名
	 */

	public static WritableSheet CreateWorkbook(String fileName) throws IOException {
		File file = new File(fileName);
		if(file.exists()) {
			file.delete();
		}
//		file.createNewFile();
		//WritableWorkbook wwb = new WritableWorkbook(file);
		WritableWorkbook wwb = Workbook.createWorkbook(file);//创建工作簿
		WritableSheet ws = wwb.createSheet("接口测试", 0);//创建工作表
		Label label1 = new Label(0, 0, "请求地址");//要写入的单元格及内容
		Label label2 = new Label(1,0,"返回状态码");
		Label label3 = new Label(2,0,"测试结果");
		try {
			ws.addCell(label1);
			ws.addCell(label2);
			ws.addCell(label3);
			wwb.write();
			wwb.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	return ws;
		
	}
	
	/*
	 * 写单元格
	 * @param fileName 传入工作簿文件名
	 * @param 传入要写入的单元格内容
	 * @param row 要写入的行号
	 * @throws IOException
	 * @param url 要写入的url
	 * @param responseCode 要写入的返回状态码
	 * 
	 */
	public void WriteCell(String fileName, String url, int responseCode, String result, int row) throws BiffException, IOException, RowsExceededException, WriteException {
		
		File file = new File(fileName);
		Workbook ws = Workbook.getWorkbook(file);
		WritableWorkbook wwb = Workbook.createWorkbook(file, ws);
		WritableSheet sheet= wwb.getSheet(0);
		Label label1 = new Label(0, row, url);
		sheet.setColumnView(0, 50);
		//sheet.setHeader("1111", "222", "3333");
		//System.out.println(ws.getVersion());
		Label label2 = new Label(1, row, Integer.toString(responseCode));
		Label label3 = new Label(2, row, result);
		sheet.addCell(label1);
		sheet.addCell(label2);
		sheet.addCell(label3);
		wwb.write();
		wwb.close();
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		String fineName = "interfaceResult.xls";
		String resourcePath=System.getProperty("user.dir");
		
		System.out.println(resourcePath);
		CreateWorkbook(fineName);
	}
}
