package Collection.Map.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wushang on 15/12/15.
 */
/*
可以实现LRU：
 */
public class _01_LinkedHashMap<K,V> extends LinkedHashMap<K,V>{
    private int capacity;

    public _01_LinkedHashMap(int capacity , boolean access) {
        super(capacity, 0.75f, access);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        System.out.println("size = " + size());
        return size() > this.capacity;
    }

    public static void main(String[] args) {
        //根据插入顺序排序
        LinkedHashMap<String,String > map = new _01_LinkedHashMap<>(4,true);
        map.put("1","11");
        map.put("2", "22");
        map.put("3", "33");
        map.put("4", "44");
        map.get("1");  // get 不会删除节点，但会改变节点的顺序
        map.put("5", "55");
        map.put("6", "66"); // 超过容量，进行删除（把最不常用的)
        map.put("5", "55");


        for(Map.Entry<String,String> entry: map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " :" + value);
        }

    }
}
