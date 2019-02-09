package day8;

import java.util.Scanner;

/**
 * 输入不必配异常事例
 * @author kenanyang
 *
 */
public class InputMismatchExceptionDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入年龄（必须是整数）");
		int age  = -1;
		//age = age / 0;
		try {
			 age = input.nextInt();
		} catch(ArithmeticException e) {
			e.printStackTrace();	
		}catch (Exception e) {
			//一般在开发的时候使用堆栈的方法打印错误信息
			e.printStackTrace();
//			System.err.println(e.getMessage()); //null
		}finally {
			System.out.println("除法计算结束");
		}
		System.out.println("输入的年龄是："+ age);
		
	}

}
