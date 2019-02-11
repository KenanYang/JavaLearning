package DownloaderDemo;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载原理
		当前案例主要实现从http协议下载文件
		1. 从HTTP协议下载文件（文件流），将文件流以缓冲流的方式读取到内存中
		   InputStream -> BufferedInputStream
		2. 缓存中的数据分块写到硬盘上（使用RandomAccessFile类实现）
 * @author kenanyang
 *
 */
public class Downloader_RandomAccessFile {
	/** 下载网址 */
	private static final String strUrl = "https://doc-00-7k-docs.googleusercontent.com/docs/securesc/6i7hq5ddn2dotgg9vep4phfjq5cifm6t/5rj6qcg4415fmmn28nk6ne7vnmae3eet/1549893600000/02297207408887823652/00306464852492411971/0B9ZnHozoUf7ZeDhlM3ItY1ROQVk?e=download&nonce=44f3selht5cv4&user=00306464852492411971&hash=3q1rbgv8hr8hfi8g8rt9gl4pcoortlp1";
	/** 设置下载时的默认缓存大小 - 10K大小 */
	private static final int MAX_BUFFER_SIZE = 10240;
	public static void main(String[] args) {
		//1. 打开http链接，获得下载内容的长度
		//2. 创建RandomAccessFile对象
		//3. 将下载的内容缓存到字节数组中
		//4. 将缓存字节数组通过RandomAccessFile对象写入到文件中（涉及到一个文件指针的操作）
		HttpURLConnection connection = null;
		BufferedInputStream bInStream = null;
		try {
			URL url = new URL(strUrl); // 创建url对象，以便获得文件流
			connection = (HttpURLConnection) url.openConnection();
			//设置链接属性 -> Range指从服务器请求下载文件的字节数范围，0- 表示不指定终止字节数
			connection.setRequestProperty("Range", "bytes=0-");
			connection.connect();//连接到服务器
			//判断连接是否成功 - 一般连接成功后，返回的代码应该在200范围内
//			1xx：指示信息，表示请求被接收，继续操作
//			2xx：成功，表示请求已被成功接收，理解，操作
//			3xx：重定向，要求完成请求必须进行下一步的操作
//			4xx：客户端错误，请求有语法错误或请求无法实现
//			5xx：服务器错误，服务器未能实现合法请求
			if(connection.getResponseCode()/100 != 2) {
				System.out.println("连接的响应状态不在200范围内，连接错误，请重试！");
				return;
			}
			int fileSize = connection.getContentLength(); //获得要下载文件的大小（字节数）
			bInStream = new BufferedInputStream(connection.getInputStream(), MAX_BUFFER_SIZE);
			int downloaded = 0; //已下载的字节数 - 用来计算当前下载的百分比
			String fileName = url.getFile(); //要求获得下载的文件名
			fileName = fileName.substring(fileName.lastIndexOf("/")+1);//截取字符串，最后一个/加一的位置开始
			RandomAccessFile file = new RandomAccessFile(fileName, "rw");
			file.setLength(0);
			file.seek(0);
			while (downloaded < fileSize) { //当前已下载的总字节数小于文件总大小时，继续下载
				byte[] buffer = null;
				// 判断为下载的大小是否超过最大缓存
				if (fileSize - downloaded > MAX_BUFFER_SIZE) {
					buffer = new byte[MAX_BUFFER_SIZE];
				}else {
					buffer = new byte[fileSize - downloaded];
				}
				//将缓冲的内容读取出来
				int read = bInStream.read(buffer);
				if(read == -1) break; //下载完毕
				//将当前下载的缓存写入多文件中
				file.seek(downloaded); // 设置文件指针
				file.write(buffer, 0, read); //写入文件
				downloaded += read;
				System.out.println("当前下载进度：" + downloaded * 1.0 / fileSize * 100 + "%");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
			try {
				bInStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
