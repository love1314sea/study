package 多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wushang on 2017/4/20.
 */
public class SlippedConditions {

	public static void main(String[] args) throws Exception{
		Lock lock = new Lock();

		ExecutorService es = Executors.newFixedThreadPool(50);
		for (int i = 0; i < 500; ++i) {
			es.execute(new Task00(lock));
		}
		Thread.sleep(1000);
		System.out.println(lock.count.get());
	}
}


class Lock {
	public AtomicInteger count = new AtomicInteger(0);
	private boolean isLocked = true;

	public void lock() {
		synchronized (this) {
			while (isLocked) {
				try {
					count.getAndIncrement();
					this.wait();
				} catch (InterruptedException e) {
					//do nothing, keep waiting
				}
			}
			isLocked = true;
		}
	}

	public synchronized void unlock() {
		isLocked = false;
		this.notify();
	}
}

class Task00 extends Thread {
	Lock lock;

	public Task00(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.lock();
		lock.unlock();
	}
}