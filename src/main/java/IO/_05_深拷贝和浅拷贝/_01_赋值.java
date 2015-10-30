package IO._05_深拷贝和浅拷贝;


public class _01_赋值 {
    public static void main(String[] args ){
        Student s1 = new Student();
        s1.setAge(14);
        s1.setName("zhang");

        Student s2 = s1; //用已存在的对象为新对象赋值，赋值的是内存地址
        s1.setAge(16);
        s1.setName("li");
        System.out.println(s2.getAge());//s1修改，s2也会修改，
        System.out.println(s2.getName());
    }
}
class Student {
    private int age;
    private String name;

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