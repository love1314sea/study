package 多线程.线程池;
/*
创建一个定长线程池，支持定时及周期性任务执行。注意是定长的。
*/
/*
public interface ExecutorService extends Executor
public interface ScheduledExecutorService extends ExecutorService
public class ScheduledThreadPoolExecutor extends ThreadPoolExecutor implements ScheduledExecutorService
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _05_newScheduledThreadPool延迟执行 {
        public static void main(String[] args) {
            MyThread t1 = new MyThread();
            //返回ScheduledExecutorService类型，它是ExecutorService的子接口
            ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
            ses.schedule(t1,3, TimeUnit.SECONDS);

            ses.schedule(new Runnable() {
                public void run() {
                    System.out.println("-----------");
                }
            },3,TimeUnit.SECONDS);
        }
}
