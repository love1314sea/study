package Collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wushang on 15/11/20.
 */
public class _01_ArrayList遍历 {
    public static void iteratorThroughRandomAccess(List list) {
        long startTime;
        long stopTime;
        startTime = System.currentTimeMillis();
        for(int i=0; i<list.size(); ++i) {
            list.get(i);
        }
        stopTime = System.currentTimeMillis();
        long interval = stopTime - startTime;
        System.out.println("iteratorThroughRandomAccess：" + interval+" ms");
    }

    public static void iteratorThroughIterator(List list) {
        long startTime;
        long stopTime;
        startTime = System.currentTimeMillis();
        for(Iterator iterator=list.iterator(); iterator.hasNext();) {
            iterator.next();
        }
        stopTime = System.currentTimeMillis();
        long interval = stopTime - startTime;
        System.out.println("iteratorThroughIterator：" + interval+" ms");
    }

    public static void iteratorThroughFor2(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Object obj:list)
            ;
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughFor2：" + interval+" ms");
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<100000; ++i) {
            list.add(i);
        }
        iteratorThroughFor2(list) ;

        iteratorThroughRandomAccess(list);
        iteratorThroughIterator(list) ;
    }
}
