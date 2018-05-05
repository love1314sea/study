package 设计模式._05_多线程Future模式;

/**
 * @author wushang@tingyun.com
 * @date 2018/5/5
 */
public interface FutureTask<T> { //类似Callable 接口

    T call();
}
