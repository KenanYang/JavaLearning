package bookDemoV2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Currency;

/**
 * 文件工具类，包含对文件的读写静态方法，方便使用
 * @author kenanyang
 *
 */
public class FileUtil {
	/** 用来进行读写操作的图书信息文件路径*/
	private static final String BookFile = "src/bookDemoV2/BookInfo.dat";
	/** 属性分隔符， 默认是， */
	private static final String separatorAttr = ",";
	/** 行的分隔符 */
	private static final String separatorLine = System.getProperty("line.separator");
	/**
	 * 将传入的图书数组写入到问价中
	 * 注意：本方法会将图书仓库数组的内容全新的写入到文件中（覆盖操作）
	 * @param bookArray
	 */
	public static void SaveBooks(Book ...bookArray) {
		if(bookArray == null || bookArray.length == 0) return;
		File bookFile = new File(BookFile);
		if(!(bookFile.exists()))
			try {
				bookFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		try(FileWriter fOut = new FileWriter(bookFile, false);
			BufferedWriter out  = new BufferedWriter(fOut);
			){
			StringBuffer content = new StringBuffer();
			for(Book book : bookArray) {
				if(book == null) break;
				content.append(book.getBookId());
				content.append(separatorAttr);
				content.append(book.getBookName());
				content.append(separatorAttr);
				content.append(book.getCount());
				content.append(separatorLine);
			}
			//将字符串写入到文件
			out.write(content.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 中文件中读取内容，将内容逐行拆解，重新整个对象、对象数组并返回
	 * @return
	 */
	public static Book[] LoadBooks() {
		File bookFile = new File(BookFile);
		if (!bookFile.exists()) return null;
		Book[] bookArray = new Book[999];//注意：读取的时候，最多999个图书对象
		try(FileReader fReader = new FileReader(bookFile);
			BufferedReader reader = new BufferedReader(fReader);
		){
			String line = null;
			int count = 0;
			while((line = reader.readLine()) != null) {
				//最好动态数组实现，这里先用普通数组
				Book currBook = new Book();
				String[] attrs = line.split(separatorAttr);//将读取的一行以属性分隔符进行分割
				currBook.setBookId(attrs[0].trim());
				currBook.setBookName(attrs[1].trim());
				currBook.setCount(Integer.parseInt(attrs[2].trim()));
				//将构建成功的图书对象添加到数组中，以便返回
				bookArray[count++] = currBook;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookArray;
	}
}
