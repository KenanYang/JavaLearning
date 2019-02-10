package JavaExceptions;

public class ExceptionDemo {
	
	/**
	 * 计算两个数字相除的商
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int divistion(int num1, int num2) {
		System.out.println("计算除法前");
		int result = Integer.MAX_VALUE;
		try {
			result = num1 / num2;
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.err.println("异常信息：" + e.getMessage());
			e.printStackTrace(); // 堆栈打印
			//日志记录
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			System.out.println("finally中的语句");
		}
		
		
		System.out.println("计算除法后"); //如果异常被捕获，这句话在发生异常后可以执行，否则不会执行
		return result; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = divistion(5,0);
		System.out.println("result = " + result);   
	}
}
