package Property;


import java.util.Iterator;
import java.util.Properties;

/**
 * Created by wushang on 15/10/31.
 */

//使用 getProperty setProperty
public class _01_获取系统属性 {
    public static void main(String[] args) {
        Properties properties = System.getProperties();

        Iterator it = properties.keySet().iterator();
        while (it.hasNext()) {
            String key = (String)it.next();
            String value =(String)properties.getProperty(key);
            System.out.println("key=" + key + " value=" + value);
        }

    }
}
