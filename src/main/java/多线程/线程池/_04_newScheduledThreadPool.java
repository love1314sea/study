package 多线程.线程池;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _04_newScheduledThreadPool {
    public static void main(String[] args) {
        MyThread_04 t1 = new MyThread_04();
        MyThread_04 t2 = new MyThread_04();
        MyThread_04 t3 = new MyThread_04();
        //创建一个定长线程池，支持定时及周期性任务执行。
        ExecutorService es = Executors.newScheduledThreadPool(2);
        es.execute(t1);
        es.execute(t2);
        es.execute(t3);//因为线程池中只有两个线程，第3个会等待可用的线程资源
    }
}
class MyThread_04 implements Runnable {
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
