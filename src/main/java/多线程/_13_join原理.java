package 多线程;

/**
 * Created by wushang on 2017/4/29.
 */
public class _13_join原理 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Task13();
		thread.start();
		System.out.println("begion join--");
		thread.join();
		System.out.println("main over--");
	}
}

class Task13 extends Thread {
	@Override
	public synchronized void start() {
		try {
			System.out.println("task start--");
			Thread.sleep(1000);
			System.out.println("task sleep over --");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.start();
	}

	@Override
	public void run() {
		System.out.println("task run");
	}
}
