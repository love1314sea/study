package 多线程.线程池;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by wushang on 2017/4/18.
 */
public class _10_异常捕获 {

	public static void main(String[] args) throws Exception{
		ExecutorService es = Executors.newFixedThreadPool(2);
		for(int i=0; i<5; ++i) {
			Future<?> future = es.submit(new DivTask(10, i));
			future.get();

//			es.execute(new DivTask(10, i));
		}
	}
}


class DivTask implements Runnable {
	int a, b;

	public DivTask(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		double re = a/b;
		System.out.println(re);
	}
}