package 并发编程.SynchronousQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by wushang on 16/10/14.
 */
public class _01_debug {
	public static void main(String[] args) throws Exception{
		BlockingQueue<String> queue = new SynchronousQueue<>();

//			System.out.println("1----");
//			queue.put("hello");
//			System.out.println("2----");
//			queue.put("world");

//			queue.take();
			System.out.println(queue.poll(1, TimeUnit.SECONDS));

	}
}
