package Collection.Map.TreeMap;


import java.util.*;

public class _01_TreeMap {
    public static void main(String[] args) {

        TreeMap map = new TreeMap();
        map.put(1,"a");
        map.put(5,"b");
        map.put(2, "b");
        map.put(4, "d");
//        map.put(null, "e");//key不能为null
        Set set = map.entrySet();
        for(Iterator iter=set.iterator();iter.hasNext();){
            Map.Entry obj =(Map.Entry)iter.next();
            int key = (int)obj.getKey();//推测：本来转换为Integer,然后自动解箱，
            String value = (String)obj.getValue();
            System.out.println(key+":"+value); //按照key的升序打印出来
        }

        System.out.println(map.ceilingEntry(5));
        System.out.println(map.ceilingEntry(5).getKey());

        NavigableSet<Integer> keySet = (NavigableSet<Integer>)map.keySet();
        System.out.println(keySet.lower(2));
        System.out.println(keySet.comparator());
        Collection<String> collection = map.values();
        collection.add("22");
        System.out.println();
//        keySet.lower()
    }
}
