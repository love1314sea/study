package 并发编程.重入锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wushang on 15/11/30.
 */
public class _02_test {

    Lock lock = new ReentrantLock();

    public Runnable createTask() {
        return new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
//                        if (lock.tryLock()) {
                        if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println("locked " + Thread.currentThread().getName());
                                Thread.sleep(1000);
                            } finally {
                                lock.unlock();
                                System.out.println("unlocked " + Thread.currentThread().getName());
                            }
                            break;
                        } else {
                            System.out.println("unable to lock -- " + Thread.currentThread().getName());
                        }
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " is Interrupted");
                    }
                }
            }
        };
    }

// 在main函数中执行
    public static void main(String[] args) throws Exception {
        _02_test run = new _02_test(); //同一个对象，以下两个线程使用同一个lock

        Thread t1 = new Thread(run.createTask(), "thread-frist");
        Thread t2 = new Thread(run.createTask(), "thread-second");
        t1.start();
        t2.start();
        Thread.sleep(600);
        t2.interrupt();
    }
}

/*
 if (lock.tryLock())

locked thread-first
unable to lock thread-second
unable to lock thread-second
.................
unable to lock thread-second
unable to lock thread-second
unlocked thread-frist
locked thread-second
unlocked thread-second
thread-second is Interrupted
locked thread-second
unlocked thread-second
 */
/*
if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {

locked thread-frist
unable to lock -- thread-second
thread-second is Interrupted //线程2 在执行lock.tryLock(500, TimeUnit.MILLISECONDS)时被中断
unlocked thread-frist
locked thread-second
unlocked thread-second


 */

