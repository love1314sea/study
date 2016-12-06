package 多线程;

/**
 * Created by wushang on 16/10/2.
 */
public class _10_join方法 {

	public static void main(String[] args) throws Exception{

		Thread thread = new Thread(new Task10());
		thread.start();

		thread.join();// 必须在调用start方法后
		System.out.println("over---");
	}
}

class Task10 implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hello");

	}
}