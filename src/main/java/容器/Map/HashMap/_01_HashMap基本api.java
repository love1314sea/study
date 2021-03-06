package 容器.Map.HashMap;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _01_HashMap基本api {
    public static void main(String[] args){
        HashMap map = new HashMap();
        map.put(null,"zhangsan");
        map.put("b",null);
        map.put("c","lisi"); //键重复会覆盖，但是值可以重复
        map.put(1,"ss");
        map.put("a","zhaoliu"); //对于已存在的key，也能存进去，但会把value替换
        System.out.println(map);

//        map.remove("c");
        System.out.println(map);

        String value = (String)map.get("a");
        String value_ = (String)map.get("b");
        System.out.println(value_);
        String value2 = (String)map.get("d");//对于不存在的key，返回null
        System.out.println(value2);
        Integer value3 = (Integer)map.get("d");//不能转换成int，因为引用不能转换成具体类型
        if(value3 == null) { //对于不存在的key，返回null
            System.out.println("not exist");
        }else {
            System.out.println(value2);
        }

        System.out.println(7&7);
        System.out.println(7&8);
        System.out.println(15&7);
        System.out.println(15&8);
    }
}
