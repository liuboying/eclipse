package boying.HttpAPITestDemo;
import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "/Users/liuboying/eclipse-workspace/HttpAPITestDemo/result.xls";
		File file = new File(filename);

		try {
			WritableWorkbook ws = Workbook.createWorkbook(file);//创建工作簿文件
			WritableSheet sheet = ws.createSheet("第一页", 0);//生成名称为”第一页“的sheet
			for(int i = 0; i < 10; i++) {
				String s = Integer.toString(i);
				Label label = new Label(i, 0, "test" + s);//单元格内容为testi
				sheet.addCell(label);//定义好的单元格添加到sheet里
			}
			ws.write();
			ws.close();
			
		} catch (IOException | WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
