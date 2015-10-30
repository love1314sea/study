package 并发编程.信号量;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by wushang on 15/10/19.
 */
public class _02_ {
    public static void main(String[] args) throws Exception{
        Semaphore semaphore = new Semaphore(4);
        System.out.println("1---" + semaphore.availablePermits()); //4
        semaphore.tryAcquire(2, TimeUnit.SECONDS);
        System.out.println("2---" + semaphore.availablePermits());//3
        semaphore.release();
        System.out.println("3---" + semaphore.availablePermits());//4
        semaphore.release(2);
        System.out.println("4---" + semaphore.availablePermits());//6
        if(semaphore.tryAcquire(5,1,TimeUnit.SECONDS)) { //1次获取5个
            System.out.println("5--" + semaphore.availablePermits());//1
        }
        if(!semaphore.tryAcquire(2,2,TimeUnit.SECONDS)) { //剩余1个，但要获取2个
            System.out.println("6--no get :" + semaphore.availablePermits());//1
        }
    }
}
