package JavaIOLearning;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFileChooser;

/**
 * 演示File类的常用方法
 * @author kenanyang
 *
 */
public class FileDemo {
//	private static final String FilePath = ".";
	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser(new File(".")); // 选择文件
		fileChooser.showOpenDialog(null); // 显示选择文件的对话框
		
		//.是当前工程所在根目录
//		File file  = new File("README.md");
		File file  = fileChooser.getSelectedFile(); //建议使用时判断文件是否为null，如果为null，则用户选择了cancel  
		System.out.println("文件/文件夹是否存在：" + file.exists());
		System.out.println("是不是一个文件：" + file.isFile());
		System.out.println("是不是一个文件夹：" + file.isDirectory());
		System.out.println("文件名/目录名：" + file.getName());
		System.out.println("绝对路径：" + file.getAbsolutePath());
		System.out.println("路径：" + file.getPath());
		System.out.println("最后修改时间：" + new Date(file.lastModified()).toLocaleString());
		System.out.println("是否隐藏：" + file.isHidden());
		System.out.println("是否可读：" + file.canRead());
		System.out.println("是否可写：" + file.canWrite());
		System.out.println("所占空间：" + file.length()); //文件夹的大小是0
		
		//使用File类创建文件/目录
//		if (!file.exists()) {
//			try {
//				if(file.isFile()) {
//					file.createNewFile();
//					System.out.println("创建文件");
//				}
//				else {
//					file.mkdir();
//					System.out.println("创建目录");
//				}
////				if(file.createNewFile())
////					System.out.println("文件/目录创建成功");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		//删除
//		if(file.exists()) {
//			file.delete(); //立即删除文件或目录
//			file.deleteOnExit(); // 在程序（进程）结束的时候再删除
//			System.out.println("Delete successfully!");
//		}
		
		//列出当前目录小所有文件
		if(file.isDirectory()) {
			String[] filenames = file.list(new DirFilter());
			for (String filename : filenames) {
				System.out.println(filename);
			}
		}
		
	
	}
	//过滤器
	//内部类 - 必须实现 filenameFilter
	static class DirFilter implements FilenameFilter{

		@Override
		public boolean accept(File dir, String name) {
			// 假设要就只显示git为后缀的文件，过滤其它后缀
			if(name.endsWith("git")||name.endsWith("project")) {
				return true;
			}
			return false;
		}
		
	}
}
