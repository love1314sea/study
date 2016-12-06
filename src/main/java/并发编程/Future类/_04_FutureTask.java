package 并发编程.Future类;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by wushang on 16/10/12.
 */
public class _04_FutureTask {

	public static void main(String[] args) throws Exception{

		FutureTask<Integer> futureTask = new FutureTask<Integer>(new Task_04());

		ExecutorService es = Executors.newFixedThreadPool(1);
		es.submit(futureTask);

		System.out.println("wait----");
		System.out.println(futureTask.get());
	}
}


class Task_04 implements Callable<Integer> {
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