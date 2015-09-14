package 碎片;

/**
 * Created by wushang on 15/8/22.
 */
public class _2 {
    public static void main(String[] args) {
        Student student = Student.build("zhang",4);
    }
}


class Student {
    String name;
    int age;
    public static Student build(String name, int age) {
        return new Student(name, age);
    }
    //设置成private
    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

}