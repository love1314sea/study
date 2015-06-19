package 并发编程;

import java.util.concurrent.*;

/**
 * Created by wushang on 15/6/16.
 */
/*
Callable+Future 获取子线程的返回结果
 */

class Task01 implements Callable<Integer> {
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return 100;
    }
}
public class _01_Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        Future<Integer> result = service.submit(new Task01());

        service.shutdown();
        System.out.println("shutdown并不阻塞主线程");
        System.out.println("result = " + result.get()); //主线程阻塞，等待子线程结果返回

    }
}
