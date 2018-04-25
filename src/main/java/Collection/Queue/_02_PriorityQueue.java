package Collection.Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wushang on 2017/3/29.
 */
public class _02_PriorityQueue {

	public static void main(String[] args) {
		PriorityQueue<Student> queue = new PriorityQueue<>(5,new CustomComparator());

		queue.add(new Student(5,"wu"));
		queue.add(new Student(4,"zhang"));
		queue.add(new Student(4, "zhao"));
		queue.add(new Student(6, "li"));
		while (!queue.isEmpty()) {
			System.out.println(queue.poll() + " ");
		}

	}

	public static class CustomComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.age != o2.age) {
				return o1.age - o2.age;
			}else {
				return o1.name.compareTo(o2.name);
			}
		}
	}
}

class Student {
	int age;
	String name;

	public Student(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[age:"+ age + ", name:" + name +"]";
	}
}


