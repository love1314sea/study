package Collection.Collections;


/**
 * Created by wushang on 16/11/2.
 */
public class _01_ {
	public static void main(String[] args) {
		Student s1 = new Student("zhang",14);
		Student s2 = new Student("li", 15);
		System.out.println(s1.compareTo(s2));

		Integer a = 7;
		Integer b = 5;
		System.out.println(a.compareTo(b));
	}
}

class Student implements Comparable<Student> {
	int age;
	String name;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student o) {
		if (age > o.age)
			return 1;
		if (age < o.age)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}
}