package jdk8.Predicate;


import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by wushang on 2018/1/10.
 */
public class _01_predicate {

	public static Student updateStudentFee(Student student, Predicate<Student> predicate, Consumer<Student> consumer) {
		if (predicate.test(student)) {
			consumer.accept(student);//consumer对传入的对象做了修改
		}
		return student;
	}

	public static Student updateStudentFee(Student student, Consumer<Student> consumer) {
		consumer.accept(student);//consumer对传入的对象做了修改
		return student;
	}

	public static void main(String[] args) {
		//java的lamda表达式其实就是 匿名类对象
		Consumer<Student> consumer = new Consumer<Student>() {
			@Override
			public void accept(Student student) {
//				student.feeDiscount = 30.0;
				if (student.grade >= 95.0) {//java的Consumer应该是没有条件判断的,
					student.feeDiscount = 30.0;
				}
			}
		};

		Student student = new Student("zhang", "san", 95.0);
		Student student1 = new Student("li", "si", 94.0);
		updateStudentFee(student, consumer);
		student.printFee();
		updateStudentFee(student1, consumer);
		student1.printFee();

		//jdk8的
		Student student3 = new Student("zhang", "san", 95.0);
		Student student4 = new Student("li", "si", 94.0);
		// s的类型lamda表达式并不知道,而是由调用函数updateStudentFee中的参数Predicate判别的
		updateStudentFee(student3, s -> s.grade >= 95, s -> s.feeDiscount = 30.0);
		student3.printFee();
		updateStudentFee(student4, s -> s.grade >= 95, s -> s.feeDiscount = 30.0);
		student4.printFee();
	}
}

class Student {
	String firstName;
	String lastName;
	Double grade;
	Double feeDiscount = 0.0;
	Double baseFee = 20000.0;

	public Student(String firstName, String lastName,
	               Double grade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
	}

	public void printFee() {
		Double newFee = baseFee - ((baseFee * feeDiscount) / 100);
		System.out.println("Theafter discount: " + newFee);
	}
}
