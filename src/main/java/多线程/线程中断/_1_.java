package 多线程.线程中断;

/**
 * Created by wushang on 17/3/15.
 */
public class _1_ {
	public static void main(String[] args) throws Exception{
		Thread task = new MyTask();
		task.start();
		task.sleep(1000);
		task.interrupt();
		Thread.sleep(5000);
	}
}

class MyTask extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(Thread.currentThread().isInterrupted());
			Thread.currentThread().interrupt();
			System.out.println(Thread.currentThread().isInterrupted());
		}
	}
}
