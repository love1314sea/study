package 并发编程.CyclicBarrier的使用;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by wushang on 15/6/18.
 */
class Worker implements Runnable {
	CyclicBarrier cb;

	public Worker(CyclicBarrier cb) {
		this.cb = cb;
	}

	public void run() {
		try {
			int i = new Random().nextInt(10);
			TimeUnit.SECONDS.sleep(i);
			System.out.println("working ----:" + i);
			cb.await();
			//do something
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

class Worker2 implements Runnable {
	CyclicBarrier cb;

	public Worker2(CyclicBarrier cb) {
		this.cb = cb;
	}

	public void run() {
		try {
//			Thread.currentThread().interrupt();//中断当前线程
			int i = new Random().nextInt(10);
//			TimeUnit.SECONDS.sleep(1000);
			System.out.println("working2 ----:" + i);
			cb.await();
			//do something
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

public class TestCyclicBarrier {
	private static final int THREAD_NUM = 3;

	public static void main(String[] args) throws Exception {

		//定义一个CyclicBarrier
		CyclicBarrier cb = new CyclicBarrier(THREAD_NUM, new Runnable() {
			public void run() {
				System.out.println("Inside Barrier: finish work--");//最后一个抵达的线程来执行
			}
		});

		for (int i = 0; i < THREAD_NUM - 1; ++i) {
			new Thread(new Worker(cb)).start();
		}
		Thread.sleep(1000);
		Thread thread = new Thread(new Worker2(cb));
		thread.start();


		Thread.sleep(5000);
		System.out.println("----");
// 重用
		for (int i = 0; i < THREAD_NUM; ++i) {
			new Thread(new Worker(cb)).start();
		}
	}
}
