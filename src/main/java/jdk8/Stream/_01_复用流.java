package jdk8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by wushang on 2018/1/10.
 */
public class _01_复用流 {
	public static void main(String[] args) {

		//使用函数接口,生成Supplier
		Supplier<Stream<String>> supplier = () -> {
			System.out.println("1---");
			return Stream.of("a1","b1","c1","a2").filter(s -> {
				System.out.println("1---" + s);
				return s.startsWith("a");
			});
		};

//		Supplier<Stream<String>> supplier2 = () -> Stream.of("a1","b1","c1");

		supplier.get().anyMatch(s -> true);//当有action的时候,流会被关闭
		supplier.get().noneMatch(s -> false);

		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double bill = costBeforeTax.stream().map((cost) -> cost).reduce((sum, cost) -> sum + cost).get();
	}
}
