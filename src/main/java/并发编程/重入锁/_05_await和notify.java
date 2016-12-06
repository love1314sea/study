package 并发编程.重入锁;

import scala.collection.LinearSeq;
import 并发编程.BlockingQueue.demo1.BlockingQueueTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wushang on 16/10/28.
 */
public class _05_await和notify {
	public static void main(String[] args) throws Exception {
		Basket4<Integer> basket = new Basket4<>(5);

		Thread p1 = new Thread(new Producer(basket));
		Thread p2 = new Thread(new Producer(basket));
		Thread p3 = new Thread(new Producer(basket));

		Thread c1 = new Thread(new Consumer(basket));
		Thread c2 = new Thread(new Consumer(basket));
		Thread c3 = new Thread(new Consumer(basket));

		p1.start();
//		p2.start();
//		p3.start();
		c1.start();
//		c2.start();
//		c3.start();

		Thread.sleep(10000);
	}
}

class Producer implements Runnable {
	Basket4<Integer> basket;

	public Producer(Basket4<Integer> basket) {
		this.basket = basket;
	}

	@Override
	public void run() {
		while (true) {
			basket.put(1);
		}
	}
}

class Consumer implements Runnable {
	Basket4<Integer> basket;

	public Consumer(Basket4<Integer> basket) {
		this.basket = basket;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(basket.get());
		}
	}
}

//1 错误示例:  使用 ReentrantLock
class Basket1<V> {
	private int maxSize;
	private LinkedList<V> list;
	private ReentrantLock lock;

	public Basket1(int maxSize) {
		this.maxSize = maxSize;
		this.list = new LinkedList<>();
		this.lock = new ReentrantLock();
	}

	public int getSize() {
		return list.size();
	}

	public List<V> getList() {
		return list;
	}

	public void put(V v) {
		lock.lock();
		try {
			while (list.size() == maxSize) {
				lock.wait(); //不能同时调用 Object.wait()方法
			}
			list.add(v);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		lock.notifyAll();
	}

	public V get() {
		V v = null;
		lock.lock(); //不能同时调用 Object.wait()方法
		try {
			while (list.size() == 0) {
				lock.wait();
			}
			v = list.removeFirst();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		lock.notifyAll();
		return v;
	}
}

// 使用synchronized Object.wait  Object.notify
class Basket2<V> {
	private int maxSize;
	private LinkedList<V> list;

	public Basket2(int maxSize) {
		this.maxSize = maxSize;
		this.list = new LinkedList<>();
	}

	public int getSize() {
		return maxSize;
	}

	public List<V> getList() {
		return list;
	}

	public synchronized void put(V v) {
		try {
			while (list.size() == maxSize) {
				System.out.println("basket is full");
				wait();  // synchronized 获得锁, wait释放锁; 等待再次获取锁
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list.add(v);
		notifyAll(); //唤醒其他线程
	}

	public synchronized V get() {
		V v = null;
		try {
			while (list.size() == 0) {
				System.out.println("basket is empty");
				wait();
			}
			v = list.removeFirst();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		notifyAll();
		return v;
	}
}

// 使用显式的对象
class Basket3<V> {
	private int maxSize;
	private LinkedList<V> list;
	private Object lock = new Object();

	public Basket3(int maxSize) {
		this.maxSize = maxSize;
		this.list = new LinkedList<>();
	}

	public int getSize() {
		return maxSize;
	}

	public List<V> getList() {
		return list;
	}

	public void put(V v) {
		synchronized (lock) {
			while (list.size() == maxSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.add(v);
			lock.notifyAll(); //同上面那种本质是一样的. 上面锁住的是this对象, 因此调用 this.wait() this.notify
			// 这个定义了一个显式对象, 因此使用显式对象来调用api
		}
	}

	public V get() {
		V v = null;
		synchronized (lock) {
			while (list.size() == 0) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			v = list.removeFirst();
			lock.notifyAll();
		}
		return v;
	}
}

//以上生产者和消费者都使用的同一个锁,二者为互斥关系,影响效率.
// 可以仿照 LinkedBlockingQueue代码
class Basket4<V> {
	private int maxSize;
	private LinkedList<V> list;
	private final ReentrantLock lock = new ReentrantLock();
	// 仓库满的条件变量
	private final Condition full = lock.newCondition();
	// 仓库空的条件变量
	private final Condition empty = lock.newCondition();

	public Basket4(int maxSize) {
		this.maxSize = maxSize;
		this.list = new LinkedList<>();
	}

	public int getSize() {
		return list.size();
	}

	public List<V> getList() {
		return list;
	}

	public void put(V v) {
		lock.lock();
		try {
			while (list.size() == maxSize) {
				System.out.println("已经满了");
				full.await();
			}
			list.add(v);
			full.signalAll(); //两个唤醒可以优化,
			empty.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public V get() {
		V v = null;
		lock.lock();
		try {
			while (list.size() == 0) {
				System.out.println("已经空了--");
				empty.await();
			}
			v = list.removeFirst();
			full.signalAll();
			empty.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return v;
	}
}
