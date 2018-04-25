package jdk8.并发;

import java.util.Arrays;

/**
 * Created by wushang on 2018/1/10.
 */
public class _01_test {

	public static void main(String[] args) {
		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		};

		new Thread(task).start();


		new Thread(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		}).start();


	}
}
