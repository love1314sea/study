package 并发编程;

import java.util.concurrent.*;

/**
 * Created by wushang on 15/6/18.
 */
public class _03_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> res = service.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return 100;
            }
        });
        System.out.println(res.get());
        service.shutdown();
    }
}
