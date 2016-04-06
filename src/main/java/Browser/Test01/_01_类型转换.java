package Browser.Test01;

/**
 * Created by wushang on 15/11/30.
 */


class Person {
    private String name;
    private int age;

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
}
class Student extends Person {
    private int grade;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

class Teacher extends Person {
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
public class _01_类型转换 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("s-1");
        s1.setAge(15);
        s1.setGrade(1);

        Person person = (Person)s1;//  子类对象能转换成父类对象
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
