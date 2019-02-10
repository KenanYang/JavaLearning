package JavaExceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 必检异常 - 除了RunTimeException和Error的其它类的子类
 * @author kenanyang
 *
 */

public class CheckedException {
	public static void main(String[] args) throws IOException {
		File file = new File("/Users/kenanyang/Desktop/Java/test.txt");
		FileWriter writer = new FileWriter(file);//文件写入， 抛出型异常，必须检测
		//判断这个文件是否存在
		System.out.println(file.exists());
	}
}
