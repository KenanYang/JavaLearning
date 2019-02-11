package JavaIOLearning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintWriterDemo {
	private static final String FilePath1 = "src/JavaIOLearning/FileDemo1.java";
	
	public static void main(String[] args) {
		//补充：关于java中的分隔符 windows - \r\n  linux - \n
		String separator = System.getProperty("line.separator"); //获得系统默认的分隔符 - 固定写法
		String content = "package JavaIOLearning;" + separator;
		content += "public class FileDemo1{" + separator;
		content += "\tpublic static void main(String[] args) {" + separator;
		content += "\t\tSystem.out.println(\"HelloWorld!\");" + separator;
		content += "\t}" + separator;
		content += "}" + separator;
		try(PrintWriter writer = new PrintWriter(new File(FilePath1))){
			writer.write(content);
			System.out.println("写入成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Scanner input = new Scanner(new File(FilePath1))) {
			StringBuffer value = new StringBuffer();
			while(input.hasNextLine()) {
				value.append(input.nextLine()); //读的时候会跳过分隔符
				value.append(separator);
			}
			System.out.println("一下是从文件中读取的内容：");
			System.out.println(value.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
