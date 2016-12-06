package 并发编程.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wushang on 16/11/18.
 */
public class _05_debug {
	public static void main(String[] args) {
		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
		map.replace("zhang","san");
		System.out.println(map.get("zhang"));
	}
}
