package 多线程.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
线程池是预先创建线程的一种技术。
在任务还没有到来之前，创建一定的线程，放入空闲队列中，然后对这些资源进行复用。
减少频繁创建和销毁对象。
*/
/*
主要涉及到：Executor接口（顶级接口)/ExecutorService(接口）/ThreadPoolExecutor(类）
        Executors(类，提供了很多静态方法）
 */
public class _01_newSingleThreadExecutor {
    public static void main(String[] args) {
        //newSingleThreadExecutor()方法，返回一个线程池。线程池中只有一个线程，这个线程会重用。
        ExecutorService es = Executors.newSingleThreadExecutor();
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        es.execute(t1); //因为只有1个线程，因此会顺序执行。
        es.execute(t2);
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<5; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread-" + i);
        }
    }
}