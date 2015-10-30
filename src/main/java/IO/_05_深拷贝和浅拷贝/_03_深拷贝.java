package IO._05_深拷贝和浅拷贝;

/*
浅拷贝：即基础类型拷贝一份，但引用类型拷贝的仍然是内存地址
1 实现Cloneable接口，同Serializable接口一样，是个标识
2 重写object类中的clone方法，并将protected更改为public
*/
public class _03_深拷贝 {
    public static void main(String[] args ) throws CloneNotSupportedException {
        Teacher_03 teacher = new Teacher_03();
        teacher.setAge(100);

        Student_03 s1 = new Student_03();
        s1.setAge(15);
        s1.setName("zhao");
        s1.setTeacher(teacher);

        Student_03 s2 = (Student_03)s1.clone();//克隆一个对象

        s1.setAge(20);
        s1.setName("li");
        teacher.setAge(1000); //这三行修改s1对象的成员变量

        System.out.println(s2.getAge()); // 没有变化
        System.out.println(s2.getName());// 没有变化
        System.out.println(s2.getTeacher().getAge());//没有变化
        /*
       深拷贝
         */

    }
}
class Teacher_03 implements Cloneable{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        return object;
    }
}
class Student_03 implements Cloneable{
    private int age;
    private String name;
    private Teacher_03 teacher;//成员变量时引用类型
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

    public Teacher_03 getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher_03 teacher) {
        this.teacher = teacher;
    }

    // 方法定义在Object类中
    public Object clone() throws CloneNotSupportedException {
        Student_03 student = (Student_03)super.clone(); //调用父类的clone方法
        student.setTeacher((Teacher_03)student.getTeacher().clone());//把里面的Teacher_03成员变量替换掉
        return student; //返回类型是Object
    }
}