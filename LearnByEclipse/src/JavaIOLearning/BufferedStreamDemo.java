package JavaIOLearning;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用带缓冲的流增加读写效率
 * @author kenanyang
 *
 */
public class BufferedStreamDemo {
	static final String FilePath1 = "src/JavaIOLearning/FileStreamDemo.java";
	static final String FilePath2 = "src/JavaIOLearning/BuffeTest.txt";
	public static void main(String[] args) {
		FileInputStream fInputStream = null;
		BufferedInputStream bInputStream = null;
		try {
			fInputStream = new FileInputStream(FilePath1);
			bInputStream = new BufferedInputStream(fInputStream);
			byte[] bytes = new byte[bInputStream.available()]; //预估的大小
			bInputStream.read(bytes);
			System.out.println(new String(bytes));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bInputStream.close();
				fInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		BufferedOutputStream bOutStream = null;
		try {
			bOutStream = new BufferedOutputStream(new FileOutputStream(FilePath2));
			bOutStream.write("今天天气很好！".getBytes("utf-8"));//使用.getBytes()一样
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bOutStream.close();
			} catch (IOException e) { 
				e.printStackTrace();
			} 
		}
	}

}
