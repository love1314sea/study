package 反射;

/**
 * Created by wushang on 16/11/9.
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Interface {
	void doSomething();

	void doSomethingElse(String str);
}

class RealObject implements Interface {
	@Override
	public void doSomething() {
		System.out.println("doSomething");
	}

	@Override
	public void doSomethingElse(String str) {
		System.out.println("doSomething else " + str);
	}
}

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.getName().startsWith("do")) {
			System.out.println("call do*** methods");
		}
		method.invoke(proxied, args);
		return null;
	}

}

public class DynamicProxy {
	public static void main(String[] args) {
		RealObject proxied = new RealObject();
		proxied.doSomething();
		proxied.doSomethingElse("leesf");
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class
				                                                     .getClassLoader(), new Class[] { Interface.class },
				new DynamicProxyHandler(proxied));
		proxy.doSomething();
		proxy.doSomethingElse("leesf");
	}
}