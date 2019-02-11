package JavaIOLearning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 使用字符流对文件进行读写操作
 */
public class ReaderAndWriterDemo {
	
	private static final String FilePath1 = "src/JavaIOLearning/FileDemo1.java";
	private static final String FilePath2 = "src/JavaIOLearning/FileDemo1.java";
	public static void main(String[] args) {
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(FilePath1));
			String line = null;
			while((line = bReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//要写入的字符串
		String content = "package JavaIOLearning;\n";
		content +="public class FileDemo1{\n";
		content +="public static void main(String[] args) {\n";
		content += "System.out.println(\"Hello World!\"); \n}\n}";
//		BufferedWriter bWriter = null;
//		try {
//			bWriter = new BufferedWriter(new FileWriter(FilePath2));
//			bWriter.write(content);//将字符串写入到缓存
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				bWriter.close(); //释放缓存，关闭文件
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(FilePath2))){
			//使用了jdk7以后新增的自动关闭资源的写法
			//使用前提：资源类必须实现Closeable接口
			bWriter.write(content);
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			//注意：由于bWriter.close会抛出IOException，这里的异常就会被新结构抑制
			//一下的代码用来查看被抑制的异常信息
			if(e.getSuppressed() != null) {
				Throwable[] throwables = e.getSuppressed();
				for (Throwable t: throwables) {
					System.err.println(t.getMessage() + "caused by" + t.getClass().getSimpleName());
				}
			}
		}
	}
}
