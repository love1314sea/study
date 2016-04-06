package 并发编程.读写锁;

import java.util.HashMap;
import java.util.Map;

// 使用synchronized 实现自己的缓存, 缓存支持并发访问(读 和 写)
/**
 * Created by wushang on 16/3/25.
 */
public class MyCache_1 {
    private Map<String, String> cache;

    public MyCache_1() {
        cache = new HashMap<>();
    }

    public synchronized String getData(String key) {
        String value = cache.get(key); // 多线程情况下, 读的时候不能写
        if (value != null)
            return value;
        //如果不存在,放入cache,并返回

        value = "result";
        putData(key, value);
        return value;
    }

    public synchronized void putData(String key, String value) {
        cache.put(key, value);
    }
}
