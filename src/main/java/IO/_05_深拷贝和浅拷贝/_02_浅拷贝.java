package IO._05_深拷贝和浅拷贝;

/*
浅拷贝：即基础类型拷贝一份，但引用类型拷贝的仍然是内存地址
1 实现Cloneable接口，同Serializable接口一样，是个标识
2 重写object类中的clone方法，并将protected更改为public
*/
public class _02_浅拷贝 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Teacher_02 teacher = new Teacher_02();
		teacher.setAge(100);

		Student_02 s1 = new Student_02();
		s1.setAge(15);
		s1.setName("zhao");
		s1.setTeacher(teacher);

		Student_02 s2 = (Student_02) s1.clone();//克隆一个对象

		s1.setAge(20);
		s1.setName("li");
		teacher.setAge(1000); //这三行修改s1对象的成员变量

		System.out.println(s2.getAge()); // 没有变化
		System.out.println(s2.getName());// 没有变化
		System.out.println(s2.getTeacher().getAge());//发生变化
	    /*
        说明是浅拷贝，基本类型的成员都拷贝了一个；但是引用类型复制的还是地址。
         */

	}
}

class Teacher_02 {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Student_02 implements Cloneable {
	private int age;
	private String name;
	private Teacher_02 teacher;//成员变量时引用类型

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher_02 getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher_02 teacher) {
		this.teacher = teacher;
	}

	// 方法定义在Object类中
//    public Object clone() throws CloneNotSupportedException {
//        Object object = super.clone(); //调用父类的clone方法
//        return object; //返回类型是Object
//    }
	public Student_02 clone() throws CloneNotSupportedException {
		Student_02 student_02 = (Student_02) super.clone();
		return student_02;
	}
}