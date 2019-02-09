package day8;

public class DivisionDemo {
	/**
	 * 计算两个字符串数字的除法（需要转化类型）
	 * @param strNum1
	 * @param strNum2
	 */
	public static void division(String strNum1, String strNum2) throws ArithmeticException, NumberFormatException { //写了throw之后在调用的时候就会强制要求处理
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 / num2;
		System.out.println("result = " + result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			division("123", "abc");
		} catch (ArithmeticException | NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("程序结束！");
	}

}
