package 反射.动态代理.demo1;

/**
 * Created by wushang on 16/11/10.
 */
public class RealSubject implements Subject
{
	@Override
	public void rent()
	{
		System.out.println("I want to rent my house");
	}

	@Override
	public void hello(String str)
	{
		System.out.println("hello: " + str);
	}

	public void read() {
		System.out.println("read a book!");
	}
}