package 设计模式._01_单例模式;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.sql.Connection;

/*
单例模式，即一个实例。
1 保证一个实例，首先，构造函数设置成private
2 返回一个实例的函数，因为不能使用对象调用，因此使用static修饰，可以使用类调用
3 保证只返回唯一的一个实例。静态函数调用成员变量，成员变量也必须是static的。
 */
public class _01_Singleton {
	public static void main(String[] args) {
		Singleton1 s1 = Singleton1.getInstance();
		Singleton1 s2 = Singleton1.getInstance();
		System.out.println(s1 == s2);

		//使用枚举
		Singleton5.INSTANCE.setName("zhangsan");
		System.out.println(Singleton5.INSTANCE.getName());
	}
}

//1 优点:简单,线程安全   缺点:非lazy的; 序列化会破坏单例
class Singleton1 {
	private static final Singleton1 singleton = new Singleton1(); //static不可缺少, 静态唯一

	private Singleton1() { //对外屏蔽构造函数
	}

	public static Singleton1 getInstance() { //对外获取实例的接口
		return singleton;
	}
}

//2 double-check方式： 优点:线程安全, lazy加载 缺点:序列化会破坏单例, 复杂
class Singleton2 {
	private static volatile Singleton2 singleton;//一定要加上volatile, 否则可能报空指针异常。（对象内部的成员没有初始化）
	// 在此的作用是：保证了有序性，编译器不会重排序，还是happen-before原则，保证对象初始化完成

	private Singleton2() {

	}

	public static Singleton2 getInstance() {
		if (singleton == null) {
			synchronized (Singleton2.class) {
				if (singleton == null) {
					singleton = new Singleton2();
				}
			}
		}
		return singleton;
	}
}

//3 Holder 方式: 优点:简单,线程安全,lazy加载 缺点:序列化会破坏单例
class Singleton3 {
	private Singleton3() {

	}

	//Singleton实例放到一个静态内部类中，这样就避免了静态实例在Singleton类加载的时候就创建对象，
	// 并且由于静态内部类只会被加载一次，所以这种写法也是线程安全的
	private static class Holder {
		private static Singleton3 singleton = new Singleton3();
	}

	public static Singleton3 getInstance() {
		return Holder.singleton;
	}
}

//4 优点:简单,线程安全,lazy加载,序列化不破坏单例  缺点:自己处理序列化readResolve()函数
class Singleton4 implements Serializable {
	private Singleton4() {

	}

	private static class Holder {
		private static Singleton4 singleton = new Singleton4();
	}

	//readResolve()：返回的对象替换反序列化创建的实例；
	public Object readResolve() throws ObjectStreamException {
		return Holder.singleton;
	}

	public static Singleton4 getInstance() {
		return Holder.singleton;
	}
}

//5 使用枚举  优点:简单,java保证枚举类型的线程安全,防止反射强行调用构造器,提供了自动序列化机制,防止反序列化的时候创建新的对象
//推荐使用..
enum Singleton5 {
	INSTANCE;

	String name;//操作 变量

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//操作函数
	public void doWhatever() {
		//do
	}
}

//参考:http://www.cnblogs.com/liaokailin/p/3196253.html
enum DatabaseConnectionPool {
	CONNECTION_POOL;//外面使用这个枚举的时候,才调用构造函数

	private DatabaseConnectionPool() {

	}


	public Connection getConnection() {
		return null;
	}

	//		DatabaseConnectionPool.CONNECTION_POOL.getConnection();

}
