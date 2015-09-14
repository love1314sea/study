package 容器.Map.HashMap;


import java.util.*;

public class _02_Map的两种遍历方式 {
    public static void main(String[] args){
        HashMap map = new HashMap();
        map.put("a","aa");
        map.put("b", "bb");
        map.put("c","cc");

        //遍历方式1： 使用keySet()获得key的集合，逐一get到值
        Set set = map.keySet();//返回Set类型，因为key不能重复；返回的是HashSet还是TreeSet不用关心
       /* Set set = new HashSet();
        set =  map.keySet(); //可以使用
        */
       // HashSet set = (HashSet)map.keySet();  //错误，不能在这里使用（）转换类型，类似于String类型不能转为(Integer)
        for(Iterator iter=set.iterator(); iter.hasNext();){
            String key = (String)iter.next();
            String value = (String)map.get(key);
            System.out.println(key +":" + value);
        }
        System.out.println("------------");
        //遍历方式2：
        Set set2 = map.entrySet();
        for(Iterator iter=set2.iterator(); iter.hasNext();){
            Map.Entry obj =(Map.Entry)iter.next();
            String key = (String)obj.getKey();
            String value = (String)obj.getValue();
            System.out.println(key+":"+value);
        }

    }
}
