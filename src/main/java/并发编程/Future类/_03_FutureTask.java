package 并发编程.Future类;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by wushang on 16/10/12.
 */
/*
FutureTask 对象既作为执行的对象; 又作为获取结果的对象
 */
public class _03_FutureTask {
	public static void main(String[] args) throws Exception{

		FutureTask<Integer> futureTask = new FutureTask<Integer>(new Task_03());

		Thread thread = new Thread(futureTask);
		thread.start();

		System.out.println("wait----");
		System.out.println(futureTask.get());
	}
}


class Task_03 implements Callable<Integer> {
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