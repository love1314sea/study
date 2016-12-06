package 并发编程.ConcurrentHashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wushang on 15/6/18.
 */
/*
ConcurrentHashMap 同Collections.synchronizedMap() 区别：
http://www.pixelstech.net/article/1394026282-ConcurrentHashMap-vs-Collections-synchronizedMap()
 */
public class _03_迭代器删除元素 {

    public static void useMap(final Map<String,Integer> scores) {
        scores.put("WU",19);
        scores.put("zhang",14);
        scores.put("sun",14);
        scores.put("zhou",14);
        try {
            Iterator<String> iterator = scores.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if(key.equals("sun")) {
                    iterator.remove();  // 首先在迭代器中删除这个元素
                }
            }
            iterator = scores.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                System.out.println(key);
            }
        }catch (Exception ex) {
            System.out.println("fail:" + ex);
        }

    }
    public static void main(String[] args) {
        useMap(new HashMap<String, Integer>());
    }
}
