package 容器.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wushang on 15/11/24.
 */
public class _03_retainAll {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>(list1);
        list2.add(4); // 如果注释，则返回false

        list1.add(5);

        boolean b = list2.retainAll(list1);//如果list2 不是list1的子集，则返回true； 如果是子集，则返回false
        System.out.println(b);

        //retailAll对list2元素作了remmove操作，求二者交集
        for(Iterator<Integer> iterator=list2.iterator(); iterator.hasNext();) {
            int res = iterator.next();
            System.out.println(res);
        }
    }
}
