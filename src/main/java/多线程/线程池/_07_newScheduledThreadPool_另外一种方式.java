package 多线程.线程池;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wushang on 15/10/30.
 */
public class _07_newScheduledThreadPool_另外一种方式 {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor monitorPool = new ScheduledThreadPoolExecutor(2,
                new ThreadFactoryBuilder().setNameFormat("lifecycleSupervisor-" + Thread.currentThread().getId() + "-%d")
                        .build());

        monitorPool.setMaximumPoolSize(3);
        monitorPool.setKeepAliveTime(20, TimeUnit.SECONDS);

        Monitor monitor1 = new Monitor();
        monitor1.setWord("zhang");
        Monitor monitor2 = new Monitor();
        monitor2.setWord("li");
        monitorPool.scheduleWithFixedDelay(monitor1, 0, 3, TimeUnit.SECONDS);

    }

}

class Monitor implements Runnable {
    String word;

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public void run() {
        System.out.println("hello:" + word);
    }
}