package collectionDemo;

/**
 * 理解泛型的基本含义
 * @author kenanyang
 *
 */

public class ElementDemo<E> {
	
	Object[] objs = new Object[999];

	public static void main(String[] args) {
		
		//泛型 - 运行时给定类型
		ElementDemo<Integer> demo = new ElementDemo<Integer>(); 
//		demo.add("abc"); //使用泛型后，类型错误时就会产生编译器的异常
		demo.add(12);
		
		ElementDemo<String> demo1 = new ElementDemo<String>();
		demo1.add("123");
 		
//	 	Object[] objs = new Object[999];
//		objs[0] = 1024;
//		objs[1] = "abs";
//		objs[2] = 19.9;
//		objs[3] = new Student();
//		
//		//从对象数组中取出对象
//		//如果转换错误，会产生classCastException - 运行时异常，无法在编译时杜绝 - 有可能造成程序的崩坏
//		Integer value1 = (Integer)objs[0];
//		String value2 = (String)objs[1];
//		System.out.println(value1);
//		System.out.println(value2);
//		
//	}
//	 
//	public static void test(Object[] objs) {
//		//将会不知道怎么取出元素
	}
	/**
	 * 想对象数组中添加给定类型的元素 - 泛型
	 * @param e
	 */
	public void add(E e) {
		//向obj中添加e元素即可
		//代码省略
	}

}

class Student{
	
}