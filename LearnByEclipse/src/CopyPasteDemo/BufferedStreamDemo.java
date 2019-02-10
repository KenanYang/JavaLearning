package CopyPasteDemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedStreamDemo {
	private static final String filePath1 = "/Users/kenanyang/Desktop/EIE4108.zip";
	private static final String filePath2 = "/Users/kenanyang/Desktop/EIE4108_copy.zip";
	
	public static void main(String[] args) throws IOException {
		//使用缓冲流装饰系统的输入对象, 使用BufferedInputStream实现Scanner
//		BufferedInputStream inStream = new BufferedInputStream(System.in);
//		byte[] bytes = new byte[200];
//		System.out.println("Please input a Char Arrays:");
//		inStream.read(bytes);
//		System.out.println("User has input a string: " + new String(bytes));
		long time = CopyFileByBufferedStream();
		System.out.println("拷贝用时：" + time + "毫秒");
		
	}
	/*
	 * 使用缓存流拷贝文件
	 * @return 拷贝过程的用时（毫秒）
	 */
	private static long CopyFileByBufferedStream() {
		File file = new File(filePath1); 
		if (!file.exists()) {
			System.out.println("File not Found, copy failed");
			return 0;
		}
		long startTime = System.currentTimeMillis();
		InputStream inStream = null;
		BufferedInputStream bInStream = null;
		OutputStream outStream = null;
		BufferedOutputStream bOutStream = null; 
		try {
			inStream = new FileInputStream(file);
			bInStream = new BufferedInputStream(inStream);
			outStream = new FileOutputStream(filePath2);
			bOutStream = new BufferedOutputStream(outStream);
			int i = -1; //读取出的临时变量
			while ((i = bInStream.read()) != -1) {
				bOutStream.write(i); //读一个写一个，注意，写入到了缓存中，没有到文件中, 需要在最后将缓存中的内容写入到文件中
				//即，需要清空缓存区，将缓存区的内容写到文件中
			}
			System.out.println("File has been copied successfully!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				bOutStream.close();//close内部自动调用了flush（）
				outStream.close();
				bInStream.close(); 
				inStream.close();
				
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
}
