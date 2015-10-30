package 容器.Map.LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wushang on 15/10/13.
 */


public class _1_LinkedHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("b",1);
        map.put("a",2);
        map.put("c",3);

        //按照插入顺序输出
        for(Map.Entry<String,Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
