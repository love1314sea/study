package Collection.Set.TreeSet;


import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class _01_TreeSet {
    public static void main(String[] args) {
        TreeSet set = new TreeSet(new MyCompare()); //默认顺序是字典顺序，自定义排序使用逆序
        set.add("a");
        set.add("b");
        set.add("c");

        for(Iterator iter = set.iterator();iter.hasNext();) {
            String value = (String)iter.next();
            System.out.println(value);
        }
    }
}
class MyCompare implements Comparator {
    public int compare(Object o1, Object o2){
        String s1 = (String)o1;
        String s2 = (String)o2;
        return -s1.compareTo(s2);
    }
}