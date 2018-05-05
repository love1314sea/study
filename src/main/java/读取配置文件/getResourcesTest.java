package 读取配置文件;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by wushang on 16/2/17.
 */
public class getResourcesTest {
    public static void main(String[] args) throws Exception{
        String fileName = getResourcesTest.class.getResource("/config2.properties").getFile();
//        String fileName3 = getResourcesTest.class.getResource("config2.properties").getFile();
        String fileName2 = getResourcesTest.class.getResource("/").getPath();
        System.out.println(fileName);
        System.out.println(fileName2);
//        System.out.println(fileName3);

        String fileName3 = getResourcesTest.class.getResource("/").getPath();
        Properties properties = new Properties();
        FileInputStream stream = new FileInputStream("file:/Users/wushang/IdeaProjects/toyprogram/study/a.csv");
        properties.load(stream);

        System.out.println(properties);
    }
}
