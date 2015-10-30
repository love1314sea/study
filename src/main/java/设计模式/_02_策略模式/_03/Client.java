package 设计模式._02_策略模式._03;
/*
1 对于这里自己有一个误区，总是潜意识以为函数参数只使用成员变量，我们可以从任意地方传入参数
2 实现两个接口，具有两个接口的特征, Comparator泛型参数化
 */

import java.util.ArrayList;
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

        Environment env = new Environment(new SortByNameASC());
        env.sort(list);
        System.out.println(list);

        for(Student s : list)
            System.out.println(s);


        /*for(Iterator iter=list.iterator(); iter.hasNext();){
            System.out.println(iter.next());
        }*/

    }
}
