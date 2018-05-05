package jdk8.Optional;

import java.util.Optional;

/**
 * Created by wushang on 2018/1/11.
 */
public class _01_optional {

	public static void say(String msg) {
		String s = (Optional.ofNullable(msg).orElseGet(()->"hello"));
		System.out.println(s.length());


	}

	public static void say(Optional<String> msg, int flag) {
//		System.out.println(msg.orElseGet(()->"").length());

		msg.ifPresent(System.out::println);
	}
//
	public static void main(String[] args) {
		say(null);
//		say(null,1);
		say("ll");

		Optional<String> opt = Optional.empty();
//		System.out.println(opt.get());
	}
}
