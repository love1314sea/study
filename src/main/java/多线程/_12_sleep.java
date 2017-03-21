package 多线程;

/**
 * Created by wushang on 17/1/8.
 */
public class _12_sleep {
	public static void main(String[] args) throws Exception{
		Thread thread = new Thread(new Task12());

		thread.start();
		thread.sleep(3000); //当前执行线程睡眠 ,即主线程睡眠; 不影响子线程thread
		System.out.println("over--");
	}
}

class Task12 implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hello");
	}
}