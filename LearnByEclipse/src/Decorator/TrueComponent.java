package Decorator;
/**
 * 真正干活的组件类
 * 实现基本的read方法
 * @author kenanyang
 *
 */
public class TrueComponent extends Component {

	@Override
	public void read() {
		System.out.println("TrueComponent实现的read方法");
	}

}
