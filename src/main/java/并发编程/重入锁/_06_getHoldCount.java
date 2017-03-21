package 并发编程.重入锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wushang on 17/1/14.
 */
//可重入的含义: 当前线程可多次持有锁,即调用多次lock方法; 想对应的,必须释放相同次数,调用unlock
public class _06_getHoldCount {

	public static void main(String[] args) {
		Service service = new Service();
		Task task01 = new Task(service);
		Task02 task02 = new Task02(service);
		task01.start();
		task02.start();
	}
}

class Service {
	private ReentrantLock lock = new ReentrantLock();

	public void serviceMethod1() {
		try {
			lock.lock();
			System.out.println("serviceMethod1: " + lock.getHoldCount());
			serviceMethod2();
			System.out.println("serviceMethod1 after: " + lock.getHoldCount());
		} finally {
//			lock.unlock();
			lock.unlock(); //如果不释放,获取和释放不对应, task02线程的serviceMethod3方法永远不会执行.
		}
	}

	public void serviceMethod2() {
		try {
			lock.lock();
			System.out.println("serviceMethod2: " + lock.getHoldCount());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void serviceMethod3() {
		try {
			lock.lock();
			System.out.println("serviceMethod3: " + lock.getHoldCount());

		} finally {
			lock.unlock();
		}
	}
}

class Task extends Thread {

	Service service;
	public Task(Service service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.serviceMethod1();
	}
}


class Task02 extends Thread {

	Service service;
	public Task02(Service service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.serviceMethod3();
	}
}