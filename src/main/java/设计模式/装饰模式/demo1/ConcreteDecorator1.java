package 设计模式.装饰模式.demo1;

/**
 * Created by wushang on 16/12/6.
 */
public class ConcreteDecorator1 extends Decorator {

	public ConcreteDecorator1(Component component) {
		super(component);
	}

	@Override
	public void dosomething() {
		super.dosomething();
		this.doAnotherThing();
	}

	private void doAnotherThing()
	{
		System.out.println("功能B..");
	}
}
