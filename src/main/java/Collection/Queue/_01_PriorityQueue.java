package Collection.Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wushang on 2017/3/29.
 */
public class _01_PriorityQueue {


	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(5);
		queue.add(7);
		queue.add(6);
		queue.add(4);

		while(!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
		System.out.println();


		PriorityQueue<Student> students = new PriorityQueue<>(512,new Comparator<Student>(){
			@Override
			public int compare(Student o1, Student o2) {
				return Long.signum(o1.getId() - o2.getId());
			}
		});

		Student s1 = new Student(100L,"a");
		Student s2 = new Student(101L,"a");
		Student s3 = new Student(99L,"a");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		System.out.println(students.peek());
		s3.id = 102;
		System.out.println(students.peek());


	}
	static class Student {
		long id;
		String name;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Student(long id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "[id=" + id + ", name=" + name +"]";
		}
	}
}


