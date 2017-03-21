package 反射.动态代理.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by wushang on 17/3/4.
 */
//封装
public class SubjectProxy {

	private Subject target;

	public SubjectProxy(Subject target) {
		this.target = target;
	}

	public Subject getSbujectProxy() {
		Subject proxy = null;
		ClassLoader loader = target.getClass().getClassLoader();
		Class[] interfaces = target.getClass().getInterfaces() ;

		InvocationHandler handler = new SubjectInvocationHandler(target);
		proxy = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);
		return proxy;
	}
}
