package 多线程.线程池;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _06_newScheduledThreadPool周期执行 {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("----");
            }
        },3,1, TimeUnit.SECONDS);//第一次执行时，延时3秒；以后每1秒执行一次

    }
}
