package 并发编程.ConcurrentLinkedQueue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by wushang on 16/10/10.
 */
public class _01_Debug {

	public static void main(String[] args) {
		Queue<String> queue = new ConcurrentLinkedQueue<>();

		queue.add("hello");
		queue.add("world");
		queue.add("zhang");
	}
}
