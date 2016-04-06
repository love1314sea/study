package 并发编程.重入锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wushang on 15/11/30.
 */
public class _01_trylock {

    Lock lock = new ReentrantLock();

    private Runnable createTask() {
        return new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
//                        if (lock.tryLock()) {
                        if (lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println("locked " + Thread.currentThread().getName());
                                Thread.sleep(5000);
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

    public void test() throws Exception{
        Thread t1 = new Thread(createTask(), "thread-frist");
        Thread t2 = new Thread(createTask(), "thread-second");
        t1.start();
        t2.start();
        Thread.sleep(600);
        t2.interrupt();
    }

    public static void main(String[] args) throws Exception {
        _01_trylock run = new _01_trylock();
        run.test();
    }
}

/*
 if (lock.tryLock()) //没参数不阻塞

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
if (lock.tryLock(500, TimeUnit.MILLISECONDS)) //阻塞一定的时间，阻塞同时会响应中断

locked thread-frist
unable to lock -- thread-second
thread-second is Interrupted //线程2 在执行lock.tryLock(500, TimeUnit.MILLISECONDS)时被中断
unlocked thread-frist
locked thread-second
unlocked thread-second


 */

