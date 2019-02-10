package Decorator;

public class ComponentImplB extends Decorator {
	public ComponentImplB(Component component) {
		super(component);
	}
	@Override
	public void read() {
		//注意：在原始的read方法前后，分别调用了自定义的方法
		//即实现了对元read方法的功能扩展 
		this.extendsReadA();
		super.read(); //原始的read方法
		this.extendsReadB();
	}
	
	private void extendsReadA() {
		System.out.println("ComponentImplB实现的扩展方法： extendsReadA");
	}
	private void extendsReadB() {
		System.out.println("ComponentImplB实现的扩展方法： extendsReadB");
	}
	
}
