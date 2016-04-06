package MyTest;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by wushang on 15/12/4.
 */
public class _05_ {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if ((Integer) o1 - (Integer) o2 > 0)
                    return 1;
                return -1;

            }
        });
        treeMap.put(5, "1");
        treeMap.put(2, "1");
        treeMap.put(2, "1.0");
        treeMap.put(4, "1");
        treeMap.put(1, "1");
        treeMap.put(3, "1");
        System.out.println("treeMap1=" + treeMap);
        treeMap.remove(treeMap.firstKey());
        treeMap.pollFirstEntry();
        treeMap.put(10, "1");
        treeMap.put(4, "1");
        System.out.println("treeMap1=" + treeMap);


    }


}
