package 反射.动态代理.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by wushang on 16/11/10.
 */

//参考: http://www.cnblogs.com/xiaoluo501395377/p/3383130.html
public class Client2 {
	public static void main(String[] args) {
		//    我们要代理的真实对象
		Subject realSubject = new RealSubject();

		SubjectProxy subjectProxy = new SubjectProxy(realSubject);
		Subject proxy = subjectProxy.getSbujectProxy();


		System.out.println(proxy.getClass().getName());
		proxy.rent();
		proxy.hello("world");

	}
}