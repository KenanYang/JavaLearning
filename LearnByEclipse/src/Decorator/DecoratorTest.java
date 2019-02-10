package Decorator;

public class DecoratorTest {

	public static void main(String[] args) {
		// 创建要被装饰的原始对象
		Component component = new TrueComponent();
		// 为原始的对象透明的增加功能
		ComponentImplA componentA = new ComponentImplA(component);
//		componentA.read();
		ComponentImplB componentB = new ComponentImplB(componentA);
		componentB.read();
	}

}
