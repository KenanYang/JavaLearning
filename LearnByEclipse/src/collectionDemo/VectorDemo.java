package collectionDemo;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
	public static void main(String[] args) {
		Vector<String> vec = new Vector<String>();
		vec.add("天龙八部"); //线程同步方法 - 更安全
		vec.addElement("天龙jiu部");// 左右和add一样，但是没有返回值
		System.out.println("size: " + vec.size());
		System.out.println("容量：" + vec.capacity());
		
		vec.trimToSize(); //是size和capacity一样
		System.out.println("Trim后的容量：" + vec.capacity());
		
		vec.ensureCapacity(3000); //增加容量到3000
		System.out.println("ensureCapacity后的容量：" + vec.capacity());
		
		//Vector的遍历
		for(int i = 0; i < vec.size(); i++) {
			System.out.print(vec.get(i) + ", ");
		}
		System.out.println();
		
//		vec.iterator()  //与List相同
		
		//枚举的遍历 - 早起版本的方式
		Enumeration<String> vecEnum = vec.elements();  //属于早起的iterator
		while(vecEnum.hasMoreElements()) {
			System.out.print(vecEnum.nextElement() + ", ");
		}
		System.out.println();
		
		//Lambda表达式 java1.8之后
		System.out.println("使用Lambda表达式遍历：");
		vec.forEach(str -> System.out.print(str + ", "));
		
		
	}
}
 