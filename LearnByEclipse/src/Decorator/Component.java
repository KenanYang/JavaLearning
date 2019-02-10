package Decorator;

/**
 * 抽象的组建类，用来定义组建的基本方法
 * @author kenanyang
 *
 */

public abstract class Component {
	/**
	 * 假设组建中定义了一个通用的read读取方法，要求子类实现
	 */
	public abstract void read();
}
