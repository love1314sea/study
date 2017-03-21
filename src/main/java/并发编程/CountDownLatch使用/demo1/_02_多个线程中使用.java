package 并发编程.CountDownLatch使用.demo1;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wushang on 16/10/4.
 */
public class _02_多个线程中使用 {
	static CountDownLatch countDownLatch = new CountDownLatch(2);


	public static void main(String[] args) throws Exception{



		Thread father = new Thread(new Father());
		father.start();

		Thread mother = new Thread(new Mother());
		mother.start();
		Thread.sleep(1000);
		Thread son = new Thread(new Son());
		son.start();


	}

	static class Son implements Runnable {

		@Override
		public void run() {

			System.out.println("son---");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countDownLatch.countDown();
		}
	}

	static class Father implements Runnable {
		@Override
		public void run() {
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("father---");
		}
	}

	static class Mother implements Runnable {
		@Override
		public void run() {
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("mother---");
		}
	}
}


