package 并发编程.Looksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by wushang on 16/11/10.
 */
//参考:  http://www.tuicool.com/articles/MveUNzF
public class _02_test {
	//
	public static void t2() throws Exception {
		Thread t = new Thread(new Runnable() {
			private int count = 0;

			@Override
			public void run() {
				long start = System.currentTimeMillis();
				long end = 0;

				while ((end - start) <= 1000) {
					count++;
					end = System.currentTimeMillis();
				}

				System.out.println("after 1 second.count=" + count);

				//等待或许许可
				LockSupport.park();
				System.out.println("thread over." + Thread.currentThread().isInterrupted());

			}
		});

		t.start();

		Thread.sleep(2000);

		// 中断线程
		t.interrupt();//线程如果因为调用park而阻塞的话，能够响应中断请求(中断状态被设置成true)，但是不会抛出InterruptedException

		Thread.sleep(2000);

		System.out.println("main over");
	}

	public static void main(String[] args) throws Exception {
		_02_test.t2();
	}
}


