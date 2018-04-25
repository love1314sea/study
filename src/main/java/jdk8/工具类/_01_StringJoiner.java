package jdk8.工具类;

import java.util.StringJoiner;

/**
 * Created by wushang on 2018/1/16.
 */
public class _01_StringJoiner {

	public static void main(String[] args) {
		StringJoiner s  = new StringJoiner("|");

		System.out.println(s.add("zhang")); //zhang

		System.out.println(s);

		System.out.println(s.add("li"));//zhang|li
		System.out.println(s);
	}
}
