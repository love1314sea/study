package 类._01_Object类;

//一般hashCode()和equals()方法，一个重写了，也要重写另外一个
public class _01_equals方法 {

    public static void main(String[] args) {
        Student s1 = new Student("zhang");
        Student s2 = new Student("zhang");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}

class Student {
    public String name;
    public Student(String name){
        this.name = name;
    }
    //override equals方法
    public boolean equals(Object anObject) {
        if(this == anObject)
            return true;
        if(anObject instanceof Student){//instanceof判断类型
            Student student = (Student)anObject;//转换
            if(student.name.equals(this.name))
                return true;
        }
        return false;
    }
}
