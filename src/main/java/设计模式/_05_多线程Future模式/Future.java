package 设计模式._05_多线程Future模式;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/5
 */
public interface Future<T> {

    T get() throws InterruptedException;

    public void done(T result);
}