package JavaIOLearning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 演示RandomAccessFile的基本用法
 * @author kenanyang
 *
 */

public class RandomAccessFileDemo {
	private static final String FilePath = "src/JavaIOLearning/RandFile.txt";
	private static final String FilePath1 = "src/JavaIOLearning/BuffeTest.txt";

	/**
	 * 使用RandomAccessFile实现文件的复制
	 */
	private static void CopyFile() {
		try(
			RandomAccessFile srcFile = new RandomAccessFile(new File(FilePath1), "r");
			RandomAccessFile newFile = new RandomAccessFile(new File(FilePath), "rw");
		){
			newFile.setLength(0);//复制之前清空
			long fileLength = srcFile.length();  //获得要复制的文件的大小
			//构建字符数组，已存放复制的内容
			byte[] bytes = new byte[(int) fileLength];
			srcFile.readFully(bytes);
			//将字节数组写入到新文件中即可
			newFile.write(bytes);
			System.out.println("文件复制成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		CopyFile();
//		File file = new File(FilePath);
//		if (!file.exists()) {
//			file.createNewFile();
//		}
//		try(RandomAccessFile randFile = new RandomAccessFile(file, "rw")){
//			randFile.setLength(0);//强制让文件大小为0，相当于删除文件内容
//			//写入2000个整型数据
//			for (int i = 0; i < 2000; i++) {
//				randFile.writeInt(i + 2000);
//			}
//			//读取文件
//			System.out.println("当前文件大小："+ randFile.length() + "字节");
//			//移动文件指针
//			randFile.seek(4*8);
//			System.out.println("移动8个整型空间后（32个字节）的值为："+ randFile.readInt());
//			randFile.seek(4*800); //移动到第800个整型处
//			randFile.writeInt(8000); //将第800个整型修改为8000
//			randFile.seek(4*800); //再次将文件指针移动第800个整型处，以便打印
//			System.out.println("移动800个整型空间后的值为："+ randFile.readInt());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
