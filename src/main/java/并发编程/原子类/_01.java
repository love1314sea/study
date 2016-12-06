package 并发编程.原子类;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wushang on 15/10/20.
 */
public class _01 {
    public static void main(String[] args) throws Exception{
        AtomicLong counter = new AtomicLong(0);
        counter.addAndGet(5);
        synchronized (counter) {
            counter.wait(3000);//里面是毫秒
        }
//        Arrays.hashCode(new byte[]{})
        System.out.println(counter.get());

    }
}
