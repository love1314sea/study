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
        String groupingKey = "ab";

        AtomicInteger count = msgCounterMap.get(groupingKey);
        int newCount = 0;
        if (count == null) {
            count = msgCounterMap.putIfAbsent(groupingKey, new AtomicInteger(1));
            if (count != null) {
                newCount = count.incrementAndGet();
            }
        } else {
            newCount = count.incrementAndGet();
        }
        Thread.sleep(100);
        System.out.println("groupingKey=" + groupingKey + ", count=" + newCount );


    }
}
