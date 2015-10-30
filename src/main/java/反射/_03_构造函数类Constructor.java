package 反射;
/*
目的：使用反射调用构造函数，构造对象
 */

import java.lang.reflect.Constructor;

public class _03_构造函数类Constructor {
    public static void main(String[] args) throws Exception{
       Class<?> classType = Student.class;
       //1 调用无参的构造函数，返回一个对象
       Constructor cons = classType.getConstructor(new Class[]{});//数组为空
       Object obj = cons.newInstance(new Object[]{});//数组为空
       //以上两行等价于下面一行
       Object obj2 = classType.newInstance();

        //2 调用有参的构造函数 ,  同使用getMethod差不多，只是少了第一个“名字”参数，因为构造函数同类名相同，没必要写
        Constructor cons2 = classType.getConstructor(new Class[]{Long.class,String.class,int.class});
        Object obj3 = cons2.newInstance(new Object[]{3L,"zhang",21});
        Student s = (Student)obj3;
        System.out.println(s.getId()+":"+s.getName()+":"+s.getAge());

    }
}

class Student {
    private Long id;
    private String name;
    private int age;

    public Student () {

    }
    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
