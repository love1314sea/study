package 并发编程.Future类;

import java.util.concurrent.*;

/**
 * Created by wushang on 15/10/13.
 */


class MyTest {
    private ExecutorService excutorService ;
    public MyTest() {
        excutorService = Executors.newFixedThreadPool(3);
    }

    public<T> T callWithTimeOut(final CallRunner<T> callRunner) throws Exception{
        Future<T> future = excutorService.submit(new Callable<T>() {
            @Override
            public T call() throws Exception {
                return callRunner.call();
            }
        });
        try {
            return  future.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new InterruptedException("a1-----");
        } catch (ExecutionException e) {
            e.printStackTrace();
            throw new ExecutionException(e);
        } catch (TimeoutException e) {
            e.printStackTrace();
            throw new TimeoutException("a2------");
        }
//        return null;
    }
    private interface CallRunner<T> {
        T call();
    }

    public void start() {
        try {
            int res = callWithTimeOut(new CallRunner<Integer>() {
                @Override
                public Integer call() {
                    try {
                        int i = 0;
                        while(i<=7) {
                            Thread.sleep(1000);
                            System.out.println("---:" + i++);

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return new Integer(5);
                }
            });
            System.out.println("res = " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public class _01_ {


    public static void main(String[]  args) {
        MyTest myTest = new MyTest();
        myTest.start();
    }
}
