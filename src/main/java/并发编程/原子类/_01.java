package 并发编程.原子类;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wushang on 15/10/20.
 */
public class _01 {
    public static void main(String[] args) {
        AtomicLong counter = new AtomicLong(0);
        counter.addAndGet(5);
        System.out.println(counter.get());

    }
}
