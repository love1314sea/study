package IO._02_字节流;

//字节流  输入流
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class _01_FileInputStream {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("C:\\Users\\wuguizhu\\Desktop\\sparksql\\cdnlog.txt");//FileInputStream继承了InputStream
        byte[] buffer = new byte[10]; //字节数组做为缓冲区
        int length = 0;
//        while(-1 != (length = is.read(buffer,0,1024))) {
        while(-1 != (length = is.read(buffer))) {
            String str = new String(buffer,0,length);//将字节流转换为字符串输出
            System.out.println(str);
        }
        is.close();

    }
}
