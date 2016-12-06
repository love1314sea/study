package 多线程.线程池;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _02_newFixedThreadPool {
    public static void main(String[] args) {
        MyThread_02 t1 = new MyThread_02();
        MyThread_02 t2 = new MyThread_02();
        MyThread_02 t3 = new MyThread_02();

        //创建一个固定大小线程的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(t1);
        es.execute(t2);
        es.execute(t3);//因为池中只有两个线程，因此第三个会等待
        System.out.println("main over---");

        es.shutdownNow();
    }
}
class MyThread_02 implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<5; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":"  + i);
        }
    }
}
