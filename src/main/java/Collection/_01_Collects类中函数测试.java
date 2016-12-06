package Collection;


import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class _01_Collects类中函数测试 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new Integer(12));
        list.add(new Integer(15));
        list.add(new Integer(4));
        for(Iterator iter=list.iterator();iter.hasNext();){
            System.out.println(iter.next());
        }
        System.out.println("1--------");
        Collections.sort(list);//对list进行排序
        for(Iterator iter=list.iterator();iter.hasNext();){
            System.out.println(iter.next());
        }
        System.out.println("2--------");
        Comparator r = Collections.reverseOrder();//获得与自然顺序相反的顺序
        Collections.sort(list,r); //制定排序规则，对list进行排序
        for(Iterator iter=list.iterator();iter.hasNext();){
            System.out.println(iter.next());
        }

        System.out.println("max=" + Collections.max(list));
        System.out.println("min=" + Collections.min(list));



    }
}
