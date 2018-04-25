package jdk8.日期时间;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by wushang on 2018/1/11.
 */
public class _01_instant {
	public static void main(String[] args) {
		Instant instant = Instant.now();
		System.out.println(instant);

		//获取时间戳
		System.out.println(Instant.now().toEpochMilli());
		System.out.println(System.currentTimeMillis());


		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
	}
}
