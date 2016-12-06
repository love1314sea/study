package 反射;

/**
 * Created by wushang on 16/11/9.
 */
import java.util.Random;
class Init1 {
	static final int staticFinal1 = 1;
	static final int staticFinal2 = Main2.random.nextInt(100);
	static {
		System.out.println("init init1");
	}
}

class Init2 {
	static int staticNonFinal1 = 3;
	static {
		System.out.println("init init2");
	}
}

class Init3 {
	static int staticNonFinal1 = 5;
	static {
		System.out.println("init init3");
	}
}

public class Main2 {
	public static Random random = new Random(47);
	public static void main(String[] args) {
		Class<?> clazzClass = Init1.class;
		System.out.println("after init init1 ref");
		System.out.println(Init1.staticFinal1);
		System.out.println(Init1.staticFinal2);

		System.out.println(Init2.staticNonFinal1);
		try {
			Class<?> clazz1 = Class.forName("反射.Init3");
			System.out.println("after init init3 ref");
			System.out.println(Init3.staticNonFinal1);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}