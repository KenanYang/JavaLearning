package day8;
/**
 * 免检异常
 * @author kenanyang
 *
 */
public class UncheckedException {

	public static void main(String[ ] args) {
		// TODO Auto-generated method stub
		String value = null;
		System.out.println(value.toString()); //没有强制检测异常
		
		String strValue = "123a";
		int value1 = Integer.parseInt(strValue);
		System.out.println(value1);
	}

}
