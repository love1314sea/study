package 多线程.线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by wushang on 2018/1/10.
 */
public class _12_ScheduledFuture {
	public static void main(String[] args) throws Exception {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

		ScheduledFuture future = service.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("begin");

				System.out.println("end---");
			}
		}, 10, TimeUnit.SECONDS);

		Thread.sleep(2000);
		System.out.println(future.getDelay(TimeUnit.SECONDS));

	}
}
