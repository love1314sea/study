package 并发编程.Future类;

import java.util.concurrent.*;

/**
 * Created by wushang on 15/11/4.
 */

/*
1 Future和 Callable he
 */

public class _01_TestFutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService service = Executors.newFixedThreadPool(3);

        Future<String> result = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "hello world";
            }
        });
        System.out.println("Let's do important things.");
        String s = null;
        try {
            s = result.get(2, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("时间到");
        }
        System.out.println(s);
        System.out.println("over");
        service.shutdown();
    }
}
