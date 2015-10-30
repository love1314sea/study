package Collection.Map.TreeMap;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class _01_TreeMap {
    public static void main(String[] args) {

        Map map = new TreeMap();
        map.put(1,"a");
        map.put(5,"b");
        map.put(2,"c");
        map.put(4,"d");

        Set set = map.entrySet();
        for(Iterator iter=set.iterator();iter.hasNext();){
            Map.Entry obj =(Map.Entry)iter.next();
            int key = (int)obj.getKey();//推测：本来转换为Integer,然后自动解箱，
            String value = (String)obj.getValue();
            System.out.println(key+":"+value); //按照key的升序打印出来
        }
    }
}
