package 并发编程.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by wushang on 16/9/27.
 */
public class _03_LinkedBlockingQueue {


	public void add() throws Exception {
		int i = 0;
		if(i>0) {
			throw new Exception("hello");
		}
	}
	public static void main(String[] args) throws Exception {
		BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
		queue.add("a");
		queue.put("b");
		queue.put("c");
//		queue.add("d");
//		queue.put("d");
		System.out.println("over----");

		System.out.println((int)(queue.size()*0.75d));

		System.out.println(5%2);
	}
}
