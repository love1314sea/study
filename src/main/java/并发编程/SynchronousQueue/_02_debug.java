package 并发编程.SynchronousQueue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by wushang on 16/10/14.
 */
public class _02_debug {

	public static void main(String[] args) throws Exception {
		BlockingQueue<String> queue = new SynchronousQueue<>();
//
		Producter p1 = new Producter("p1", queue);
		Producter p2 = new Producter("p2", queue);
		p1.start();
		Thread.sleep(1000);
//		p2.start();


		Consumer c1 = new Consumer("c1", queue);
//		Consumer c2 = new Consumer("c2", queue);
		c1.start();
		Thread.sleep(1000);
//		c2.start();
	}
}

class Producter extends Thread {
	BlockingQueue<String> queue;

	public Producter(String name, BlockingQueue<String> queue) {
		super(name);
		this.queue = queue;
	}

	@Override
	public void run() {

		if(Thread.currentThread().getName().equals("p1")) {
			try {
				System.out.println("p1  1-----");
				queue.put("hello");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(Thread.currentThread().getName().equals("p2")) {
			System.out.println("p2  1-----");
			try {
				queue.put("world");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("p2  2-----");
		}
	}
}


class Consumer extends Thread {
	BlockingQueue<String> queue;
	String name;

	public Consumer(String name, BlockingQueue<String> queue) {
		this.name = name;
		this.queue = queue;
	}

	@Override
	public void run() {

		if(name.equals("c1")) {
			try {
				System.out.println("c1  1-----");
				queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(name.equals("c2")) {
			System.out.println("c2  1-----");
			try {
				queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("c2  2-----");
		}
	}
}