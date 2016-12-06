package 容器.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wushang on 16/9/21.
 */
public class _01_基础知识 {

	public void testString() {
		System.out.println("testString------------");
		String a = "hello";//在 常量池中
		String b = a; //
		b = "world";
		System.out.println(a);
		System.out.println(b);
	}

	public void testPerson() {
		System.out.println("testPerson------");
		Person person = new Person("zhangsan", 14);
		Person person2 = person;
		person2 = new Person("lisi", 12);
		System.out.println(person);
		System.out.println(person2);
	}

	public void testPerson2() {
		System.out.println("testPerson2------");
		Person person = new Person("zhangsan", 14);
		Person person2 = person;
		person2.name = "lisi";
		System.out.println(person);
		System.out.println(person2);
	}

	public void testMapString() {
		System.out.println("testMapString------");
		Map<String, String> map = new HashMap<>();
		map.put("hello", "world");
		String v = map.get("hello");
		v += " boy";
		System.out.println(map.get("hello"));
		System.out.println(v);
	}

	public void testMapLong() {
		System.out.println("v------");
		Map<String, Long> map = new HashMap<>();
		map.put("hello", 4L);
		Long v = map.get("hello");
		v++;
		System.out.println(map.get("hello"));
		System.out.println(v);
	}

	public static void main(String[] args) throws Exception {
		_01_基础知识 demo = new _01_基础知识();
		demo.testString();
		demo.testPerson();
		demo.testPerson2();
		demo.testMapString();
		demo.testMapLong();
	}
}

class Person {

	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}
}