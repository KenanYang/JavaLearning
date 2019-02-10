package JavaIOLearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 比较原始的InputStream/OutputStream的一些方法
 * @author kenanyang
 *
 */
public class FileStreamDemo {
	private static final String FilePath = "src/JavaIOLearning/FileDemo.java";
	public static void main(String[] args) throws IOException {
		ReadFile();
		writeFile();
		
	}
	public static void writeFile() throws IOException {
		final String FilePath1 = "src/JavaIOLearning/FileDemo1.java";
//		OutputStream outStream = new FileOutputStream(FilePath1, true);//有true是追加写入
		OutputStream outStream = new FileOutputStream(FilePath1, false); //false会覆盖写
		String content = "package JavaIOLearning;";
		content +="public class FileDemo1{\n";
		content +="public static void main(String[] args) {\n";
		content += "System.out.println(\"Hello World!\"); \n}\n}";
		outStream.write(content.getBytes()); //核心语句是将字符串转换成字节数组，写入到文件中
		//写完一定要关闭资源
		outStream.close();
	}
	
	public static void ReadFile() throws IOException {
		File file = new File(FilePath); //省略判断
		InputStream inputStream = new FileInputStream(file);
		//读取文件的基本操作 - 相对比较固定
		//inputStream.available() 获取输入流可以读取的文件大小（字节），一般是准确的
//		byte[] bytes = new byte[inputStream.available()];
		byte[] bytes = new byte[20000];
//		int count = 0;
//		while((bytes[count] = (byte)inputStream.read()) != -1) { //读到-1就会退出
//			count ++;
//		}
		//不实用循环读取，直接读取：
		inputStream.read(bytes);
		String content = new String(bytes); //将读取的字节转换成字符串，一边打印
		System.out.println(content);
		inputStream.close();
	}
}
