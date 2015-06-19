package 并发编程.ConcurrentHashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wushang on 15/6/18.
 */
/*
ConcurrentHashMap 同Collections.synchronizedMap() 区别：
http://www.pixelstech.net/article/1394026282-ConcurrentHashMap-vs-Collections-synchronizedMap()
 */
public class _01_普通map的错误 {

    public static void useMap(final Map<String,Integer> scores) {
        scores.put("WU",19);
        scores.put("zhang",14);
        try {
            for(final String key : scores.keySet()) {
                System.out.println(key + ":" + scores.get(key));
                scores.put("liu",12);
            }
        }catch (Exception ex) {
            System.out.println("Fail:" + ex);
        }
    }
    public static void main(String[] args) {
        System.out.println("Using Plain vanilla HashMap");
        useMap(new HashMap<String, Integer>());
        System.out.println("Using synchronized HashMap");    //不能在迭代遍历的同时，对map做更新
        useMap(Collections.synchronizedMap(new HashMap<String, Integer>()));

        System.out.println("Using concurrent HashMap"); //能够更新
        useMap(new ConcurrentHashMap<String, Integer>());
    }
}
