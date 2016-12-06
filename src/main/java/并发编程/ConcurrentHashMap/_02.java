package 并发编程.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wushang on 16/1/19.
 */
public class _02 {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, AtomicInteger> msgCounterMap = new ConcurrentHashMap<>();
        msgCounterMap.put("a", new AtomicInteger(1));
        int size = msgCounterMap.size();
        System.out.println();

    }
}
