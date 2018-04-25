package jdk8.Collectors;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by wushang on 2018/1/16.
 */
public class _01_自定义生成Collector {

	public static void main(String[] args) {
		Collector<String, StringJoiner, String> collector = Collector.of(() -> new StringJoiner("|"),
				(j, s) -> j.add(s), (j1, j2) -> j1.merge(j2), StringJoiner::toString
		);

		String s  =Arrays.stream(new String[]{"zhang","li"}).collect(collector);
		System.out.println(s);
	}
}
