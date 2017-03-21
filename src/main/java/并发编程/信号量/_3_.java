package 并发编程.信号量;

import java.util.concurrent.Semaphore;

/**
 * Created by wushang on 17/1/19.
 */
public class _3_ {
	public static void main(String[] args) throws Exception {
		Semaphore semaphore = new Semaphore(3, true); // 如果使用公平的, 先到的线程如果获取不到足够的资源,会一直阻塞后面的线程
		Thread t1 = new Task(semaphore, 2, "t1");
		t1.start();
		Thread.sleep(500);
		Thread t2 = new Task(semaphore, 4, "t2");
		t2.start();
		Thread.sleep(500);

		Thread t3 = new Task(semaphore, 1, "t3");
		t3.start();


	}
}


class Task extends Thread {
	Semaphore semaphore;
	int num;
	String name;

	public Task(Semaphore semaphore, int num, String name) {
		super();
		this.semaphore = semaphore;
		this.num = num;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " begin");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " over-");
		semaphore.release(num);

	}
}