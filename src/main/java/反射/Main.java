package 反射;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

interface SuperInterfaceA {
};

interface SuperInterfaceB {
};

class SuperC {
	private String name;

	public SuperC() {

	}

	public SuperC(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}

class Sub extends SuperC implements SuperInterfaceA, SuperInterfaceB {
	private String name;

	public Sub() {
		super();
	}

	public Sub(String name) {
		super(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

public class Main {
	public static Sub makeInstance(Class<?> clazz) {
		Sub sub = null;
		try {
			sub = (Sub) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return sub;
	}

	public static void printBasicInfo(Class<?> clazz) {
		System.out.println("CanonicalName : " + clazz.getCanonicalName());
		System.out.println("Name : " + clazz.getName());
		System.out.println("Simple Name : " + clazz.getSimpleName());
		System.out.println("SuperClass Name : "
				                   + clazz.getSuperclass().getName());
		Class<?>[] interfaces = clazz.getInterfaces();
		for (Class<?> inter : interfaces) {
			System.out.println("Interface SimpleName : "
					                   + inter.getSimpleName());
		}
		Constructor<?>[] constructors = clazz.getConstructors();
		for (Constructor<?> cons : constructors) {
			System.out.println("Constructor Name : " + cons.getName());
		}
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("Method Name : " + method.getName());
		}
	}

	public static void main(String[] args) {
		//Sub sub = new Sub();
		//Class<?> clazz = sub.getClass();
		Class<?> clazz = Sub.class;
		Sub instance = makeInstance(clazz);
		if (instance != null) {
			System.out.println("make instance successful");
		} else {
			System.out.println("make instance unsuccessful");
		}
		printBasicInfo(clazz);
	}
}