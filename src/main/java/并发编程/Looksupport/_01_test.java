package 并发编程.LookSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by wushang on 16/11/10.
 */
public class _01_test {
	public static void main(String[] args) throws Exception {
		Thread thread = Thread.currentThread();

		LockSupport.unpark(thread);//相等于线程中有个状态位,把状态位置为1
		LockSupport.unpark(thread);//仍然是1

		System.out.println("a");
		LockSupport.park();// 0
		System.out.println("b");
		LockSupport.park();//许可只有1个, 仍然会阻塞在这里
		System.out.println("c");
	}
}
