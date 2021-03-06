package 并发编程.synchronize和lock效率对比;

/**
 * Created by wushang on 16/10/3.
 */

/**
 * @author YHJ create at 2013-4-26 下午05:35:35
 * @Described：带同步的测试
 * @ClassNmae com.yhj.lock.AtomicIntegerWithLock
 */
public class AtomicIntegerWithSynchronized implements AtomicIntegerTestCase {

	private int value;
	private Object lock = new Object();//为保证两个方法都在同步内 采用对象同步方法

	@Override
	public int incrementAndGet() {
		synchronized (lock) {
			return ++value;
		}
	}

	@Override
	public int get() {
		synchronized (lock) {
			return value;
		}
	}

}