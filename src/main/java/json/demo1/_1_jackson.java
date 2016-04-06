package json.demo1;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wushang on 16/3/23.
 */
public class _1_jackson {
    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("string", "hello");
        map.put("int", 1);
        Map<String, String> innerMap = new HashMap<>();
        innerMap.put("in1", "1");
        innerMap.put("in2", "2");
        map.put("map", innerMap);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(map);
        System.out.println(json);

        Map<String, Object> deMap = objectMapper.readValue(json, Map.class);
        Object object = map.get("map");
        System.out.println(object);

        Map<String, String> strMap = (Map<String,String>)object;
        System.out.println(strMap.get("in1"));
    }
}
