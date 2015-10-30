package Collection.Set.TreeSet;

/*
自定义类实现Comparable接口，重写compareTo方法
 */
import java.util.Iterator;
import java.util.TreeSet;

public class _03_TreeSet自定义排序 {
    public static void main(String[] args){
        TreeSet set = new TreeSet();
        set.add(new Student_3(20));
        set.add(new Student_3(30));
        set.add(new Student_3(15));
        Iterator iter=set.iterator();
        while(iter.hasNext()){
            Student_3 value = (Student_3)iter.next();
            System.out.println(value);
        }
    }
}
//自定义类实现Comparable接口，重写compareTo方法
class Student_3 implements Comparable {
    int age;
    public Student_3(int age){
        this.age = age;
    }
    public String toString(){
        return String.valueOf(age);
    }
    public int compareTo(Object o) {
        Student_3 s = (Student_3)o;
        return this.age-s.age;
    }

}
