package 并发编程.Future类;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by wushang on 16/10/12.
 */
/*

这种启动方式,不是多线程执行, 而是一般函数调用.

不是异步执行. 注意和多线程区分开.
 */
public class _02_FutureTask {

	public static void main(String[] args) throws Exception {


		FutureTask<Integer> futureTask = new FutureTask<Integer>(new Task_02());

		futureTask.run();// 不通过Thread.start() 来启动, 则是普通的调用,不是异步的

		System.out.println("wait-----");

		Integer i = futureTask.get();

		System.out.println("i=" + i);
	}
}

class Task_02 implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i < 10; ++i) {
			sum += i;
		}
		Thread.sleep(2000);
		return sum;
	}
}