package 容器.Map;

/**
 * Created by wushang on 15/7/14.
 */
public class _1 {
	private static final sun.misc.Unsafe UNSAFE;
	private static final long nameOffset;
	private static final long ageOffset;
	static {
		try {
			UNSAFE = sun.misc.Unsafe.getUnsafe();
			Class<?> k = Person.class;
			nameOffset = UNSAFE.objectFieldOffset
					                    (k.getDeclaredField("head"));
			ageOffset = UNSAFE.objectFieldOffset
					                    (k.getDeclaredField("tail"));
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	public void test() {
		Person p = new Person("zhangsan",19);
		UNSAFE.compareAndSwapObject(p, nameOffset, null, "li");
		System.out.println(p);
	}
	public static void main(String[] args) throws Exception {
		_1 demo = new _1();
		demo.test();

	}
}
