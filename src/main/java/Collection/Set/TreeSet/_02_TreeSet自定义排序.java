package Collection.Set.TreeSet;
/*
TreeSet容器中存放的元素，必须是可排序的。
如果我们存放自定义的类型，必须自定义比较器，来构造TreeSet
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class _02_TreeSet自定义排序 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet(new MyCompare2());//使用自定义比较器构造
        set.add(new Student(20));
        set.add(new Student(30));
        set.add(new Student(15));

      /*  for(Iterator iter=set.iterator(); iter.hasNext();){
            Student value = (Student)iter.next();
            System.out.println(value);
        }*/
        Iterator iter=set.iterator();
        while(iter.hasNext()){
            Student value = (Student)iter.next();
            System.out.println(value);
        }
    }
}
class Student{
    public int age;
    public Student(int age){
        this.age = age;
    }
    public String toString(){//自定义输出，重写toString方法
        return String.valueOf(age);
    }
}
//自定义比较规则，实现Comparator接口，重写compare方法
class MyCompare2 implements Comparator {
    public int  compare(Object o1, Object o2){
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;
       /* if(s1.age > s2.age)
            return 1; //升序，s1在s2前面
        else if(s1.age == s2.age)
            return 0;
        else
            return -1;*/
        return s1.age -s2.age;
    }
}