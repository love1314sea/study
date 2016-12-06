package 并发编程.synchronize和lock效率对比;

/**
 * Created by wushang on 16/10/3.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YHJ create at 2013-4-26 下午05:35:35
 * @Described：带锁的测试
 * @ClassNmae com.yhj.lock.AtomicIntegerWithLock
 */
public class AtomicIntegerWithLock implements AtomicIntegerTestCase {

	private int value;
	private Lock lock = new ReentrantLock();

	@Override
	public int incrementAndGet() {
		try {
			lock.lock();
			return ++value;
		} finally {
			lock.unlock();
		}

	}

	@Override
	public int get() {
		try {
			lock.lock();
			return value;
		} finally {
			lock.unlock();
		}
	}

}