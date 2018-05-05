package 设计模式._05_多线程Future模式;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/5
 */
public class AsyncFuture<T> implements Future<T> {

    private T result;

    private volatile boolean done = false;

    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            while (!done) {
                this.wait();
            }
            return result;
        }
    }

    @Override
    public void done(T result) {
        synchronized (this) {
            this.result = result;
            this.done = true;
            this.notifyAll();
        }
    }
}
