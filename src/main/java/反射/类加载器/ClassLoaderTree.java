package 反射.类加载器;

/**
 * Created by wushang on 16/11/16.
 */
public class ClassLoaderTree {

	public static void main(String[] args) {
		ClassLoader loader = ClassLoaderTree.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader.toString());
			loader = loader.getParent();
		}

		String s = "hello";
		ClassLoader classLoader = String.class.getClassLoader(); //由booststrap
		System.out.println(classLoader);

		System.out.println(ClassLoader.getSystemClassLoader());
	}
}

/*
sun.misc.Launcher$AppClassLoader@234f79cb
sun.misc.Launcher$ExtClassLoader@36c51089
 */