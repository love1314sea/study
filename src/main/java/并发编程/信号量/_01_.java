package 并发编程.信号量;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by wushang on 15/10/19.
 */
public class _01_ {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        try {
//            semaphore.release();
//            System.out.println(semaphore.availablePermits());
            boolean isGet = semaphore.tryAcquire(5, TimeUnit.SECONDS);//如果在规定时间内得不到信号，返回false
            if(isGet) {
                System.out.println("get----");
            }else {
                System.out.println("no get----");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class A extends Thread{
    @Override
    public void run() {
        System.out.println("A run--------");
    }
}


class B extends Thread{
    @Override
    public void run() {
        System.out.println("B run--------");
    }
}