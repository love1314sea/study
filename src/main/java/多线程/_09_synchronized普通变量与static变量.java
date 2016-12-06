package 多线程;

/**
 * Created by wushang on 16/10/2.
 */
public class _09_synchronized普通变量与static变量 {

	public static void main(String[] args) {
		Thread thread = new Thread(new Task(), "t1");
		Thread thread2 = new Thread(new Task(), "t2");
		thread.start();
		thread2.start();

	}

}

class Task implements Runnable {
	//	public  Object object = new Object();  // 无序打印
	public  static Object object = new Object();//有序打印
	@Override
	public void run() {
		synchronized (object) {
			for(int i=0; i<10; i++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " : " + i);
			}
		}
	}
}
