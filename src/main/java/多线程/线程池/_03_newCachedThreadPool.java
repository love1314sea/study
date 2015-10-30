package 多线程.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class _03_newCachedThreadPool {
    public static void main(String[] args) {
        MyThread_02 t1 = new MyThread_02();
        MyThread_02 t2 = new MyThread_02();
        MyThread_02 t3 = new MyThread_02();
        //可缓存的线程池
        //当有新的任务，就创建新的线程。当线程闲置一段时间(60秒），线程就会回收。
        //当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
        //线程池的大小，依赖于操作系统（或jvm）能够创建的最大线程数目。
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(t1); //3个会同时运行
        es.execute(t2);
        es.execute(t3);
    }
}
