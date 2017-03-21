package 并发编程.ThreadLocal;

/**
 * Created by wushang on 17/1/13.
 */
public class _03_ {

	public static void main(String[] args) {
		ThreadLocal<Integer> threadLocal = new ThreadLocal();

		Thread thread = new Task01(threadLocal);
		thread.start();
		Thread thread2 = new Task02(threadLocal);
		thread2.start();

	}
}

class Task01 extends Thread {
	ThreadLocal<Integer> threadLocal;

	public Task01(ThreadLocal<Integer> threadLocal) {
		this.threadLocal = threadLocal;
	}

	@Override
	public void run() {

		System.out.println("thread=" + Thread.currentThread().getName() +  " num=" + threadLocal.get());
	}
}


class Task02 extends Thread {
	ThreadLocal<Integer> threadLocal;

	public Task02(ThreadLocal<Integer> threadLocal) {
		this.threadLocal = threadLocal;
	}

	@Override
	public void run() {

		System.out.println("thread=" + Thread.currentThread().getName() +  " num=" + threadLocal.get());
	}
}