package 并发编程.重入锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wushang on 17/1/31.
 */
public class _07_lockinterruptibly {

	public static void main(String[] args) throws InterruptedException {
		Task06 task06 = new Task06();
		task06.start();
	}
}

class Task06 extends Thread {
	Lock lock = new ReentrantLock();

	@Override
	public void run() {

		Thread.currentThread().interrupt();
		System.out.println("begin--");
		try {
			lock.lockInterruptibly();//会响应中断
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}

		try {
			System.out.println("lock---");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();//如果没有获取锁,而调用unlock,会抛出异常
			System.out.println("unlock---:" + Thread.currentThread().isInterrupted());
		}


	}
}