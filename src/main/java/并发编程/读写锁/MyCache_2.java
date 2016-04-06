package 并发编程.读写锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// 使用读写锁 实现自己的缓存, 缓存支持并发访问(读 和 写)

/**
 * Created by wushang on 16/3/25.
 */
public class MyCache_2 {
    private Map<String, String> cache;
    private ReadWriteLock readWriteLock;

    public MyCache_2() {
        cache = new HashMap<>();
        readWriteLock = new ReentrantReadWriteLock();
    }

    public String getData(String key) {

        readWriteLock.readLock().lock();
        String value = null;
        try {
            value = cache.get(key); // 多线程情况下, 读的时候不能写, 因此读的时候也要加锁,防止同时有写的动作
        } finally {
            readWriteLock.readLock().unlock();
        }
        if (value == null) {
            readWriteLock.writeLock().lock();
            try {
                value = cache.get(key);  // 在 写锁 锁定之前有时间差,可能别的线程已经放入数据,因此再检查一次
                if (value == null) {
                    value = "get result";
                    cache.put(key, value);
                }
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }
        return value;
    }

    public void putData(String key, String value) {

        cache.put(key, value);
    }
}
