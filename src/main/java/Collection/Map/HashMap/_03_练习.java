package Collection.Map.HashMap;

/*
随机生成50个整数，范围是[10,40],统计每个数字出现的次数。找出出现最多的次数。按数字升序排列打印出来。
 */

import java.util.*;

public class _03_练习 {
    public static void main(String[] args) {

        Map map = new TreeMap();//使用TreeMap自动排序,存储出现的数字和次数
        Random random = new Random();

        for(int i=0; i<50; i++){
            int ram = random.nextInt(41) + 10;//生成[10,50]的随机数
        //    System.out.println(ram);
            Integer in = new Integer(ram);
            if(map.get(in) == null) {
                map.put(in, 1);
            }else {
                int value = ((Integer)map.get(in)).intValue() + 1;
                map.put(in, new Integer(value));
            }
        }

        Set set = map.entrySet();
        for(Iterator iter=set.iterator();iter.hasNext();){
            Map.Entry entry = (Map.Entry)iter.next();
            Integer key = (Integer)entry.getKey();
            Integer value = (Integer)entry.getValue();
            System.out.println(key+":"+value);
        }

        Collection col = map.values();
        Integer max =(Integer) Collections.max(col);
        System.out.println("max=" + max);
    }
}
