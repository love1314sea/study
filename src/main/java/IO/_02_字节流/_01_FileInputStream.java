package IO._02_字节流;

//字节流  输入流
import java.io.*;

public class _01_FileInputStream {
    public static void main(String[] args) throws IOException {
//        InputStream is = new FileInputStream("C:\\Users\\wuguizhu\\Desktop\\sparksql\\cdnlog.txt");//FileInputStream继承了InputStream
        InputStream is = new FileInputStream("/Users/wushang/Downloads/active_source/part-00001");//FileInputStream继承了InputStream
        byte[] buffer = new byte[1024]; //字节数组做为缓冲区
        long startTs = System.currentTimeMillis();

        OutputStream os = new FileOutputStream("/Users/wushang/Downloads/active_source/part-00001-bak");//无则创建，有则清空内容，再写

        int length = 0;
//        while(-1 != (length = is.read(buffer,0,1024))) {
        while(-1 != (length = is.read(buffer))) {
//            String str = new String(buffer,0,length);//将字节流转换为字符串输出
//            System.out.println(str);
            ;
            os.write(buffer);
        }
        is.close();
        os.close();
        System.out.println("duration=" + (System.currentTimeMillis() - startTs));
//        duration=6226
//        duration=38593


    }
}
