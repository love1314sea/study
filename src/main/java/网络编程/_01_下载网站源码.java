package 网络编程;

/*
下载sina的网页源码，并保存在本地文件
 */

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class _01_下载网站源码 {

    public static void test1() throws Exception{
        URL url = new URL("http://www.qq.com/");

        URLConnection conn = url.openConnection();//建连
        InputStream is = conn.getInputStream(); //获得源码流
        //  InputStream is2 = url.openStream(); //可以用这一行代替上面两行

        byte[] buffer = new byte[1024];
        int length = 0;
        OutputStream os = new FileOutputStream("D://sina.html");
        while(-1 != (length = is.read(buffer,0,buffer.length))) {
            os.write(buffer,0,buffer.length);
        }
        is.close();
        os.close();
    }

    public static void test2() throws Exception {
        URL url = new URL("http://www.sina.com");
        //使用字符流
        BufferedReader br = new BufferedReader( new InputStreamReader( url.openStream()));
        String line = null;
        while(null != (line = br.readLine())) {
            System.out.println(line);
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        test1();
        test2();
    }
}
