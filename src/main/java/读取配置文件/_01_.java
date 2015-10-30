package 读取配置文件;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created by wushang on 15/10/20.
 */
/*
1 都是相对编译之后的路径
2 配置文件必须放在resources目录下，其他位置并不编译进包。如：config3.properties不会编译进包
3 resources下编译出来都是根目录
4 参考：http://www.open-open.com/lib/view/open1423116557482.html
 */
public class _01_ {

    private static void loadProperties(String cfgFile, Properties properties) {
        InputStream in = null;
        if(cfgFile.startsWith("file:")) {
            try {
                in = new FileInputStream(cfgFile.substring(5));
            } catch (FileNotFoundException e) {
                System.err.println("kafka config file not found: " + cfgFile);
            }
        } else if(cfgFile.startsWith("/")) {
            in = _01_.class.getResourceAsStream(cfgFile);
        } else {
            try {
                in = new FileInputStream(cfgFile);

            } catch (FileNotFoundException e) {
                System.err.println("kafka config file not found: " + cfgFile);
            }
        }
        if(in != null) {
            try {
                System.out.println("load kafka config from file: " + cfgFile);
                properties.load(in);
            } catch (IOException e) {
                System.err.println("IO exception when loading kafka-producer.properties: " + e.getMessage());
            } finally {
                try {
                    in.close();
                } catch (IOException e) {

                }
            }
        } else {
            System.err.println("in is null");
        }

    }

    public static void traverseMap(Map<Object,Object> map) {
        for(Map.Entry<Object,Object> entry : map.entrySet()) {
            System.out.println("key=" + entry.getKey() + " value=" + entry.getValue());
        }
        System.out.println("---------------");
    }
    public static void traveseProperties(Properties properties) {
//        for(properties.keys())
    }

//    Enumeration<?> propertyNames = properties.propertyNames();
//    while (propertyNames.hasMoreElements()) {
//        String name = (String) propertyNames.nextElement();
//        String value = properties.getProperty(name);
//        result.put(name, value);
//    }
    public static void main(String[] args) {
        Properties properties = new Properties();
        _01_.loadProperties("/config1.properties", properties);//能读取，
        traverseMap(properties);

        properties = new Properties();//可以使用绝对路径，则用FileInputStream
        _01_.loadProperties("file:/Users/wushang/IdeaProjects/study/src/main/config3.properties", properties);
        traverseMap(properties);

        properties = new Properties();
        _01_.loadProperties("/conf.local/config3.properties", properties);
        traverseMap(properties);

//        System.out.println(System.getProperty("java.class.path"));
//        System.out.println(System.getProperty("user.dir"));
    }
}
