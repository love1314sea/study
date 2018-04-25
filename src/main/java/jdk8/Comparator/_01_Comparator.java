package jdk8.Comparator;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wushang on 2018/1/10.
 */
public class _01_Comparator {

	public void useOrigin() {
		List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));
		//使用传统的方法进行排序
		//sort直接修改原来的数组
		Collections.sort(humans, new Comparator<Human>() {
			@Override
			public int compare(Human h1, Human h2) {
				return h1.getName().compareTo(h2.getName());
			}
		});
	}

	public void useLamda() {
		List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));

//		humans.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));

		humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
	}

	public static int compareByNameThenAge(Human lhs, Human rhs) {
		if (lhs.name.equals(rhs.name)) {
			return lhs.age - rhs.age;
		} else {
			return lhs.name.compareTo(rhs.name);
		}
	}
	public static void useStaticMethod() {
		List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));


		humans.sort(_01_Comparator::compareByNameThenAge);

	}


	public static void main(String[] args) {


	}
}

class Human {
	public String name;
	public int age;

	public Human() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Human(final String name, final int age) {
		super();

		this.name = name;
		this.age = age;
	}

	// standard getters and setters
}