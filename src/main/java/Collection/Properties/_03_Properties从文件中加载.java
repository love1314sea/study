package Collection.Properties;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class _03_Properties从文件中加载 {
    public static void main(String[] args) throws IOException {
        testProperties();
    }
    public  static void testProperties() throws IOException {
        InputStream is = new FileInputStream("C:\\Users\\wuguizhu\\Desktop\\storm\\properties.txt");
        Properties prop = new Properties();
        prop.load(is);
        is.close();

        for(Object key : prop.keySet()) {
            System.out.println(key + "=" + prop.get(key));
            System.out.println("---" + key + "=" + prop.getProperty((String)key));
        }


    }
}
