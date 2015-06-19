package 并发编程.CountDownLatch使用.demo1;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wushang on 15/6/18.
 */
/*
jdk文档中CountDownLatch的示例
 */
public class Driver {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(3);

        for(int i=0; i<3 ; ++i)
            new Thread( new Worker(startSignal, doneSignal)).start();
        System.out.println("start---");
        startSignal.countDown();

        doneSignal.await();

        System.out.println("all finish-----");


    }
}
class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }
    public void run() {
        try {
//            TimeUnit.SECONDS.sleep(new Random().nextInt(3));
            Thread.sleep(3000);
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doWork() {
        System.out.println("working---");
    }
}