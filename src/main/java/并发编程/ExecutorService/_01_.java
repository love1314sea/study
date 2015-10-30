package 并发编程.ExecutorService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wushang on 15/10/16.
 */
public class _01_ {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                while (true) {
                    System.out.println(i++);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });
        try {
            pool.shutdown();// Disable new tasks from being submitted
            // Wait a while for existing tasks to terminate
            if(!pool.awaitTermination(1, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks, 会给sleep发一个状态
                if (!pool.awaitTermination(1, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
                else
                    System.err.println("Pool did  terminate");
            }else {
                System.out.println("no  termination");
            }
        }catch (Exception e) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }

    }
}
