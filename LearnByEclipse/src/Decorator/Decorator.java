package Decorator;

/**
 * 装饰器父类，用来为基本的组件实现功能的扩展
 * @author kenanyang
 *
 */

public class Decorator extends Component{
	private Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		//将请求转发给component对象，转发后，就可以执行一些扩展操作了
		component.read();
	}

}
