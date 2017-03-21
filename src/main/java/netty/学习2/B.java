package netty.学习2;

/**
 * Created by wushang on 17/3/9.
 */
public class B {
	private A a;

	public void doIt() {
		a = new A(this);
	}

	public void register(A a) {
	}

}
