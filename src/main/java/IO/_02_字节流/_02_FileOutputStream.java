package IO._02_字节流;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//字节流 输出流
public class _02_FileOutputStream {

    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream("./a.txt");//无则创建，有则清空内容，再写
        String str = "hello world";
        byte[] buffer = str.getBytes();
        os.write(buffer);
        os.close();
        os = new FileOutputStream("./a.txt",true);//追加
        os.close();


        FileOutputStream fos = new FileOutputStream("./txt");
        fos.write(500);
        fos.close();

	    System.out.println(500 & 0xFF);
    }

}
