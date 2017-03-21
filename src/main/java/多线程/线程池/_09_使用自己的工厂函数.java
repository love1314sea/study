package 多线程.线程池;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wushang on 16/12/7.
 */
public class _09_使用自己的工厂函数 {
	public static void main(String[] args) throws Exception {
		//
//		ExecutorService es = Executors.newFixedThreadPool(2, new CustomThreadFactory());
		//使用guava
		ExecutorService es = Executors.newFixedThreadPool(2, new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build());


	}
}

class CustomThreadFactory implements ThreadFactory {
	private final AtomicInteger threadNumber = new AtomicInteger(1);
	@Override
	public Thread newThread(Runnable r) {

		Thread t = null;
		t = new Thread(r, "thread-" + threadNumber.getAndAdd(1));
		return t;
	}
}
