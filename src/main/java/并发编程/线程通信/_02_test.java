package 并发编程.线程通信;

/**
 * Created by wushang on 17/1/11.
 */
//测试:  1 wait会释放锁   2 如果没有notify通知,会一直阻塞
public class _02_test {
	public static void main(String[] args) {

		Object object = new Object();
		Task task01 = new Task(object);
		Task task02 = new Task(object);
		task01.start();
		task02.start();

	}
}


class Task extends Thread {
	Object object;

	public Task(Object object) {
		this.object = object;
	}

	@Override
	public void run() {
		synchronized (object) {
			for (int i = 0; i < 10; i++) {
				while (i == 5) {// 注意: 是while
					try {
//						object.wait(1000);
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

