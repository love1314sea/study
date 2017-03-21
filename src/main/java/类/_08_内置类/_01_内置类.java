package 类._08_内置类;

/**
 * Created by wushang on 17/1/10.
 */
public class _01_内置类 {
	public static void main(String[] args) {
		Person person = new Person();

//		Person.Student student = new  Person.Student(); //错误
		Person.Student student = person.new Student(); // 使用外部对象.new 来生成内部类的对象.
		System.out.println(student.age);
	}
}

class Person {
	public String name;
	public String sex;

	class Student { //
		public int age;
		public String address;
	}
}
