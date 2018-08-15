package boying.HttpAPITestDemo;

import java.io.File;

/**
 * @author liuboying
 *
 */
public class IOStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("/Users/liuboying/eclipse-workspace/HttpAPITestDemo/未命名1");
		boolean isFile = file.isFile();
		System.out.println(isFile);
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		File file1 = new File("/Users/liuboying/eclipse-workspace/HttpAPITestDemo/test.txt");
		System.out.println(file1.getAbsolutePath());
		file1.mkdir();//创建名为test.txt的目录
		
	}

}
