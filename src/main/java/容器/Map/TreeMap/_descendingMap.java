package 容器.Map.TreeMap;



import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by wushang on 15/12/21.
 */
public class _descendingMap {
    public static void main(String[] args) {
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1, "1");
        treeMap.put(3, "3");
        treeMap.put(2, "2");

        NavigableMap<Integer, String> treeMap1 = treeMap.descendingMap();
        for(Map.Entry<Integer,String> entry : treeMap1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        treeMap.put(4, "4");
        System.out.println("-------------------");
        for(Map.Entry<Integer,String> entry : treeMap1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
