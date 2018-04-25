package 并发编程.原子类;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wushang on 2018/1/6.
 */
public class _02_AtomicInteger {
	static {
		System.out.println("hello");
	}

	public static void main(String[] args) {
		AtomicLong counter1 = new AtomicLong(0);

		counter1.set(2);

		System.out.println(counter1.getAndSet(3));

		System.out.println(counter1.compareAndSet(4,5));//false
		System.out.println(counter1.compareAndSet(3,5));//true


	}
}
