package 设计模式._02_策略模式._03;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//实现两个接口，具有两个接口的特征, Comparator泛型参数化
public class SortByNameASC implements SortInterface,Comparator<Student>{
    @Override
    public void sort(List<Student> list) {
        Collections.sort(list, this); //因为SortByNameASC实现了Comparator接口，重写了compare函数，使用this对象即可
    }

    @Override
    public int compare(Student o1, Student o2) {
        int res = o1.getName().compareTo(o2.getName());
        if(0 == res)
            return o1.getId() - o2.getId();
        return res;
    }
}
