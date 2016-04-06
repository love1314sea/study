package 读取配置文件;

/**
 * Created by wushang on 16/2/17.
 */
public class getResourcesTest {
    public static void main(String[] args) {
        String fileName = getResourcesTest.class.getResource("/config2.properties").getFile();
//        String fileName3 = getResourcesTest.class.getResource("config2.properties").getFile();
        String fileName2 = getResourcesTest.class.getResource("/").getPath();
        System.out.println(fileName);
        System.out.println(fileName2);
//        System.out.println(fileName3);

    }
}
