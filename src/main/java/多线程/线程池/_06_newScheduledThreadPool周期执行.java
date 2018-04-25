package 多线程.线程池;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _06_newScheduledThreadPool周期执行 {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
        ses.scheduleAtFixedRate(new Runnable() {
//        ses.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start : " + System.currentTimeMillis()/1000);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end : " + System.currentTimeMillis()/1000);
            }
        },1,2, TimeUnit.SECONDS);//第一次执行时，延时3秒；以后每1秒执行一次

    }
}
