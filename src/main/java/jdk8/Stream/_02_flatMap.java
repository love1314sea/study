package jdk8.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by wushang on 2018/1/16.
 */
public class _02_flatMap {

	public static void main(String[] args) {
		List<Foo> foos = new ArrayList<>();
		IntStream.range(0, 4).forEach(i -> foos.add(new Foo("Foo-" + i)));

		foos.forEach(f -> IntStream.range(0, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + "<-" + f.name))));


		foos.stream().flatMap(f ->f.bars.stream()).forEach(b -> System.out.println(b.name));

	}
}

class Foo {
	String name;
	List<Bar> bars = new ArrayList<>();

	Foo(String name) {
		this.name = name;
	}
}

class Bar {
	String name;

	Bar(String name) {
		this.name = name;
	}
}