package 并发编程.线程通信;

/**
 * Created by wushang on 16/10/3.
 */
/*
参考: <<java 并发编程的艺术>>
4.3.2 等待/通知机制

A线程获得锁, 如果条件不满足,则wait;
B线程更改条件,并通知A线程
 */
public class _01_wait和notify {

	static Object lock = new Object();//锁
	static boolean flag = false;

	public static void main(String[] args) throws Exception{
		Thread waitThread = new Thread(new Wait(), "waitThread");
		waitThread.start();
		Thread.sleep(3000);

		Thread notifyThread = new Thread(new Notify(), "notifyThread");
		notifyThread.start();

	}

	static class Wait implements Runnable {
		@Override
		public void run() {
			synchronized (lock) {
				while (!flag) { // 检查条件,即使被激活,也要检查条件

					try {
						System.out.println(Thread.currentThread().getName() + " flag=" + flag + " wait");
//						lock.wait();//释放锁, 线程放入 WaitQueue; 会唤醒后,线程由WaitQueue 到 SynchronizedQueue
						lock.wait(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " over");
			}
		}
	}

	static class Notify implements Runnable {
		@Override
		public void run() {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + " notify");
				flag = true;
				lock.notifyAll();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//执行结束,释放锁
		}
	}
}

