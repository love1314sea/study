package 并发编程;

import java.util.concurrent.*;

/**
 * Created by wushang on 15/6/16.
 */
//public class _02_FutureTask {
//    public static void main(String[] args) {
//        //第一种方式
//        ExecutorService executor = Executors.newCachedThreadPool();
//        Task02 task = new Task02();
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
//        executor.submit(futureTask);
//        executor.shutdown();
//
//        //第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
//        /*Task02 task = new Task02();
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
//        Thread thread = new Thread(futureTask);
//        thread.start();*/
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }
//
//        System.out.println("主线程在执行任务");
//
//        try {
//            System.out.println("task运行结果"+futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("所有任务执行完毕");
//    }
//}
//class Task02 implements Callable<Integer> {
//
//    public Integer call() throws Exception {
//        System.out.println("子线程在进行计算");
//        Thread.sleep(3000);
//        int sum = 0;
//        for(int i=0;i<100;i++)
//            sum += i;
//        return sum;
//    }
//}
/*
FutureTask 既实现了Runnalbe接口，也实现了Callable接口，因此可以使用两种方法调用。
 */
class Task02 implements Callable<Integer> {
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return 300;
    }
}
public class _02_FutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Task02 task = new Task02();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        service.submit(futureTask);
        service.shutdown();
        System.out.println(futureTask.get());

        //方式2:使用Thread.start
        System.out.println("----------");
        Task02 task02 = new Task02();
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(task02);
        Thread thread = new Thread(futureTask1);
        thread.start();
        System.out.println(futureTask1.get());
    }
}