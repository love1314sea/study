package 容器.Map.HashMap;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _01_HashMap基本api {
    public static void main(String[] args){
        HashMap map = new HashMap();
        map.put("a","zhangsan");
        map.put("b","lisi");
        map.put("c","lisi"); //键重复会覆盖，但是值可以重复
        map.put(1,"ss");
        map.put("a","zhaoliu"); //对于已存在的key，也能存进去，但会把value替换
        System.out.println(map);

        String value = (String)map.get("a");
        System.out.println(value);
        String value2 = (String)map.get("d");//对于不存在的key，返回null
        System.out.println(value2);
        Integer value3 = (Integer)map.get("d");//不能转换成int，因为引用不能转换成具体类型
        if(value3 == null) { //对于不存在的key，返回null
            System.out.println("not exist");
        }else {
            System.out.println(value2);
        }
    }
}
