package 容器.Map.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wushang on 15/10/13.
 */

class FixedSizeLinkedHashMap extends LinkedHashMap<String,Integer> {
    private static final long serialVersionUID = 6918023506928428613L;
    private static int MAX_ENTRIES = 10;
    public void setMAX_ENTRIES(int max_entries) {
        MAX_ENTRIES = max_entries;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
}
public class _2_删掉最老使用的 {
    public static void traverseMap(Map<String,Integer> map){
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey()+":" + entry.getValue() + " " );
        }
        System.out.println();
    }
    public static void main(String[] args) {
        FixedSizeLinkedHashMap map = new FixedSizeLinkedHashMap();
        map.setMAX_ENTRIES(3);
        map.put("a", 1);
        map.put("b", 2);
        map.put("c",3);
        traverseMap(map);
        map.put("d",4);
        traverseMap(map);

    }
}
