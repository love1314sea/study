package 多线程.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by wushang on 2018/1/6.
 */
public class _11_返回结果 {

	public static void main(String[] args) throws Exception{
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<?> future = es.submit(new MyThread11());
//		Future<?> future = es.submit(new MyThread11(),5);
		System.out.println("1----");

//		Thread.sleep(1000);
//		future.cancel(false);

		System.out.println(future.get());
		System.out.println("2----");
	}
}

class MyThread11 implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<5; ++i) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread-" + i);
		}
	}
}
