package 并发编程.Looksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by wushang on 16/11/10.
 */
public class _01_test {
	public static void main(String[] args) throws Exception {
		Thread thread = Thread.currentThread();

		LockSupport.unpark(thread);
		LockSupport.unpark(thread);

		System.out.println("a");
		LockSupport.park();
		System.out.println("b");
		LockSupport.park();//许可只有1个, 仍然会阻塞在这里
		System.out.println("c");
	}
}
