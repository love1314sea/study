package 设计模式._02_策略模式._02;
/*
目的：有若干个Student对象存在一个List中，对它们进行排序。
要求：分别按名字、年龄、id进行排序（升序)
     如果年龄或姓名相同，则按id正序排序，id不可能重复。
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Student s1 = new Student(3, 10,"li");
        Student s2 = new Student(2, 13,"li");
        Student s3 = new Student(4, 1,"wang");
        Student s4 = new Student(1, 1,"guo");

        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        Strategy strategy = new sortByAge();
        Collections.sort(list,new Environment(strategy));
        System.out.println(list);

        for(Student s : list)
            System.out.println(s);

        Strategy strategy2 = new sortById();
        Collections.sort(list,new Environment(strategy2));
        System.out.println(list);

        Strategy strategy3 = new sortByName();
        Collections.sort(list,new Environment(strategy3));
        System.out.println(list);
        /*for(Iterator iter=list.iterator(); iter.hasNext();){
            System.out.println(iter.next());
        }*/

    }
}
