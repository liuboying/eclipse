package iostudy.lby;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("/Users/liuboying/eclipse-workspace/IOStudy/test/test1.txt");//只创建对象，并不真正创建文件/目录本身
		boolean isFile = file.isFile();//判断对象是否为文件对象
		System.out.println("Befter invoke createNewFile, file.isFile = " + isFile);
		System.out.println("Befter invoke mkdirs, file.isDirectory = " + file.isDirectory());//判断对象是否为路径对象
		System.out.println("file.getName() = " + file.getName());
		System.out.println("Before invoke file.getFreeSpace(), file.getFreeSpace = " + file.getFreeSpace());
		System.out.println("file.getAbsolutePath = " + file.getAbsolutePath());
		System.out.println("file.getPath = " + file.getPath());
		System.out.println("file.getParent" + file.getParent());
		if(!file.exists()) {
			file.mkdirs();//如果目标目录的上级目录不存在，则会创建上级目录及本机目录
			System.out.println("目录不存在");
		}else {
			file.delete();
			file.mkdirs();//如果目标目录的上级目录不存在，则会创建上级目录及本机目录
			System.out.println("目录存在");
		}
		System.out.println("After invoke mkdirs, file.isDirectory = " + file.isDirectory());//判断对象是否为路径对象
		System.out.println("After invoke file.getFreeSpace(), file.getFreeSpace = " + file.getFreeSpace());//查看目录/文件的可用空间
		
		System.out.println(file.separator);//当前系统分隔符
		System.out.println(file.separatorChar);
		System.out.println(file.pathSeparator);
		System.out.println(file.pathSeparatorChar);
		System.out.println(file.getParentFile());
//		file.deleteOnExit();//退出java虚拟机时，删除创建的文件目录/文件，删除目录时只删除最后一级目录，不删除同时创建的上一级目录，如本例中的test目录不删除
		
		

			
		File file1 = new File("/Users/liuboying/eclipse-workspace/IOStudy/hello.txt");
		if(!file1.exists()) {
			try {
				file1.createNewFile();//此处创建名称为test2.txt的文件
				System.out.println(file1.isFile());
				System.out.println("文件不存在");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			file1.delete();
			try {
				System.out.println("文件存在");
				file1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//此处创建名称为test2.txt的文件
		}
		//file1.deleteOnExit();//java虚拟机关闭时，删除对应目录/文件
		System.out.println("file1.canExecute() = " + file1.canExecute());
		System.out.println("file1.canRead() = " + file1.canRead());
		System.out.println("file1.canWrite() = " + file1.canWrite());
		
		File file2 = new File("/Users/liuboying/eclipse-workspace/IOStudy");
		String[] array = file2.list();//查看当前目录File对象下的文件/文件夹名称
		System.out.println(array.length);
		for(int i = 0; i < array.length; i ++) {
			System.out.println(i + "=" + array[i]);
		}
		System.out.println("file2.isAbsolute() = " + file2.isAbsolute());//当前对象是绝对路径
		
		File file3 = new File("hello1.txt");
		
		System.out.println("file3.isAbsolute() = " + file3.isAbsolute());//当前对象不是绝对路径
		System.out.println("file3.canExecute() = " + file3.canExecute());//在目录/文件实际创建前，canExecute,canRead,canWrite方法均返回false
		System.out.println("file3.canRead() = " + file3.canRead());
		System.out.println("file3.canWrite() = " + file3.canWrite());
		System.out.println("file3.lastModified() = " + file3.lastModified());
		
		if(file3.exists()) {
			file3.delete();
			file3.mkdir();
		}else {
			file3.mkdir();
		}
		System.out.println("After invoke file3.mkdir(),file3.canExecute() = " + file1.canExecute());
		file3.setExecutable(true);
		System.out.println("After invoke file3.setExecutable(true, false), file3.canExecute() = " + file3.canExecute());
		System.out.println("After invoke file3.mkdir(),file3.canRead() = " + file1.canRead());
		System.out.println("After invoke file3.mkdir(),file3.canWrite() = " + file1.canWrite());
		System.out.println(file3.toString());
		System.out.println("file3.getAbsolutePath() = " + file3.getAbsolutePath());
		file3.renameTo(new File("hello2.txt"));
		System.out.println("After invoke file3.renameTo(new File(\"hello2.txt\")), the filePath is " + file3.getName());
		file3.deleteOnExit();
//		
//		File file1 = new File("/Users/liuboying/eclipse-workspace/HttpAPITestDemo/test.txt");
//		System.out.println(file1.getAbsolutePath());
//		try {
//			file1.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		file1.mkdir();//创建名为test.txt的目录
//		System.out.println(file.isDirectory());//判断对象是否为路径对象
		
		File file4 = new File("testxx.txt");
		if(file4.exists()) {
			file4.delete();
			try {
				file4.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				file4.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			FileReader fr = new FileReader("/Users/liuboying/eclipse-workspace/IOStudy/helloxx.txt");
			int hasCode = 0;
			char[] cbuf = new char[1024];
			//hasCode = fr.read(cbuf);
			System.out.println(hasCode);
			
			while((hasCode = fr.read(cbuf))> 0) {
				String s = new String(cbuf, 0, hasCode);
				System.out.println(hasCode);
				System.out.println(s);
				System.out.println("**************");
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
