package 并发编程.线程中断;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wushang on 16/10/30.
 */
public class _06_线程中断的原理 {
	private static ReentrantLock lock = new ReentrantLock();
	public static Runnable createTask() {
		return new Runnable() {
			@Override
			public void run() {
				System.out.println("1:" + Thread.currentThread().isInterrupted());
				for (long i=0; i<=1000000000000000000L; ++i) {
					i+=i;
				}
				System.out.println("2:" + Thread.currentThread().isInterrupted());

				try {
					lock.lockInterruptibly();
					System.out.println("sleep---");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("3:" + Thread.currentThread().isInterrupted());

					e.printStackTrace();
				}
				try {
					System.out.println("be");
					Thread.sleep(5000);
					System.out.println("end");
					System.out.println(Thread.currentThread().isInterrupted());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	}


	public static void main(String[] args) {
		System.out.println(Thread.currentThread().isInterrupted() +"---");

		Thread thread = new Thread(createTask(), "abc");
		thread.start();
		thread.interrupt();
	}
}
