package 设计模式.装饰模式.demo1;

/**
 * Created by wushang on 16/12/6.
 */
public class Decorator implements Component {
	private Component component; //继承了Component, 并且还有一个Component的成员

	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public void dosomething() {
		component.dosomething();
	}
}
