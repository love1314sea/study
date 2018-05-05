package 设计模式._05_多线程Future模式;


import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/5
 */
//1 桥接作用： 把 Future（返回结果）和 FutureTask（任务逻辑） 整合在一起
    // 2 引入回调
public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> task) { //consumer作为回调
        Future<T> future = new AsyncFuture<>(); // future 在多个线程中共享
        new Thread(new Runnable() {
            @Override
            public void run(){
                T result = task.call();//执行这个任务，并获取返回结果
                future.done(result);
            }
        }).start();
        return future;
    }

    public <T> Future<T> submit(final FutureTask<T> task, Consumer<T> consumer) { //consumer作为回调
        Future<T> future = new AsyncFuture<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                T result = task.call();
//                future.done(result); //因为有了回调，可以不返回结果。
                consumer.accept(result);
            }
        }).start();
        return future;
    }
}
