package 多线程.线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by wushang on 16/4/9.
 */
public class _08_InvokeAll方法 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(new Task("1"));
        tasks.add(new Task("2"));
        tasks.add(new Task("3"));
        try {
            List<Future<String>> futures = service.invokeAll(tasks, 3, TimeUnit.SECONDS);
            for(Future<String> future : futures) {
                System.out.println(future.get());
            }
////            service.invokeAll(tasks);
//            for(Callable task: tasks) {
//                service.submit(task);
//            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("over -----");

    }
}

class Task implements Callable<String> {
    public String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return name + ":OK";
    }
}