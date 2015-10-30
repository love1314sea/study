package Collection.Properties;
/*
Properties类继承自HashTable类，HashTable已经不用了，而使用HashMap
Properties的本质还是一个容器
很多函数：keySet get，Properties类并没有重写，而是继承自HashTable
 */

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class _01_System环境变量 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("hello"));
        Properties p = System.getProperties(); //主要是System类中静态成员函数，返回的是Properties类型

        //遍历1：
        Set set = p.keySet();
        for(Iterator iter=set.iterator(); iter.hasNext();) {
            String key = (String)iter.next();
            String value= (String)p.get(key);

          //  System.out.println( key + "=" + value);
        }

        System.out.println("-----------------------");
        //使用for新特征来遍历
        for(Object key : p.keySet()){
         //   System.out.println("--" + key + "=" + p.get(key));
        }
    }
}
