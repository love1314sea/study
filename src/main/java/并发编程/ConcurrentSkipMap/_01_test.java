package 并发编程.ConcurrentSkipMap;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by wushang on 2017/5/7.
 */
/*
1 线程安全
2 key是有序的
 */
public class _01_test {
	public static void main(String[] args) {
		ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>();
		map.put("hello",1);
		map.put("world",2);
		map.put("china",3);

		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println("k=" + k + " v=" + v);
		}
	}
}
