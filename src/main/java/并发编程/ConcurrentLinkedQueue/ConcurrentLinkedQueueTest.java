package 并发编程.ConcurrentLinkedQueue;

/**
 * Created by wushang on 15/6/18.
 */
/*
适用于先进先出场景
 */
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentLinkedQueueTest {
    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
    private static int count = 100000;
    private static int count2 = 2; // 线程个数
    private static CountDownLatch cd = new CountDownLatch(count2);

    public static void dothis() {
        for (int i = 0; i < count; i++) {
            queue.offer(i);
        }
    }

    static class Poll implements Runnable {

        public void run() {
//			while (queue.size()>0) { //size()效率很慢
            while (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
            cd.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(4);
        ConcurrentLinkedQueueTest.dothis();
        for (int i = 0; i < count2; i++) {
            es.submit(new Poll());
        }
        cd.await();
        System.out.println("cost time " + (System.currentTimeMillis() - timeStart) + "ms");
        es.shutdown();
    }


}