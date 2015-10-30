package 设计模式._02_策略模式._03;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByNameDESC implements SortInterface,Comparator<Student> {
    @Override
    public void sort(List<Student> list) {
        Collections.sort(list, this);
    }

    @Override
    public int compare(Student o1, Student o2) {
        int res = o1.getName().compareTo(o2.getName());
        if(0 == res)
            return o1.getId() - o2.getId();
        return -res;
    }
}
