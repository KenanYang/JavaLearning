package PropertiesDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		//读取properties文件的常做方式
		Properties props = new Properties();
		//加载文件
		props.load(PropertiesDemo.class.getResourceAsStream("Config.properties"));
		
		//读取配置
		String value = props.getProperty("book"); // 通过key获得value
		System.out.println(value);
		//向配置文件中写内容 - 尽量少用
		props.setProperty("name", "Monkey.D.Luffy");
		FileOutputStream outStream = new FileOutputStream("bin/PropertiesDemo/Config.properties"); //写要写入到bin中
		props.store(outStream, "comments of properties");
		
		props.load(PropertiesDemo.class.getResourceAsStream("Config.properties"));
		System.out.println("show all key-value pair in config file");
		for(Entry<Object, Object> entry : props.entrySet()) {
			System.out.println(entry.getKey() + "---" + entry.getValue());
		}
	}

}
