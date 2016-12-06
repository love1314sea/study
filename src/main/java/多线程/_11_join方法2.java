package 多线程;

/**
 * Created by wushang on 16/10/2.
 */
public class _11_join方法2 {
	public static void main(String[] args) throws Exception {
		Thread previous = Thread.currentThread();

		for (int i = 0; i < 10; ++i) {

			Thread thread = new Thread(new Task11(previous), String.valueOf(i));
			thread.start();
			previous = thread;
		}
		Thread.sleep(100);
	}
}

class Task11 implements Runnable {
	private Thread thread;

	public Task11(Thread thread) {
		this.thread = thread;
	}

	@Override
	public void run() {

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " in");

	}
}
