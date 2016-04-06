package 并发编程.重入锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wushang on 15/11/30.
 */
public class _03_lock {

    Lock lock = new ReentrantLock();

    private Runnable createTask() {
        return new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        lock.lock();//阻塞函数
                        try {
                            System.out.println("locked " + Thread.currentThread().getName());
                            Thread.sleep(1000);
                        } finally {
                            lock.unlock();
                            System.out.println("unlocked " + Thread.currentThread().getName());
                        }
                        break;

                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " is Interrupted");
                    }
                }
            }
        };
    }

    public void test() throws Exception {
        Thread t1 = new Thread(createTask(), "thread-frist");
        Thread t2 = new Thread(createTask(), "thread-second");
        t1.start();
        t2.start();
        Thread.sleep(600);
        t2.interrupt();
    }

    public static void main(String[] args) throws Exception {
        _03_lock run = new _03_lock();
        run.test();
    }
}

/*
lock.lock();//阻塞函数，不会响应中断

locked thread-frist
unlocked thread-frist
locked thread-second
unlocked thread-second
thread-second is Interrupted
locked thread-second
unlocked thread-second
 */
