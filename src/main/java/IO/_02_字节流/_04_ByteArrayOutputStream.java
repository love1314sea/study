package IO._02_字节流;


import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class _04_ByteArrayOutputStream {

    public static void main(String[] args) throws IOException {
        //ByteArrayOutputStream 中有一个字节数组
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String str = "hello world";
        byte[] buffer = str.getBytes();
        f.write(buffer); //输出流，也要有输入源。buffer是输入源，写入 f中，准备输出.
        f.write(100);//打印char时,转换成d

        byte[] result = f.toByteArray();//输出

        for(int i=0; i<result.length;++i) {
            System.out.println((char)result[i]); //打印每个字符
        }



        OutputStream os = new FileOutputStream("d:/a.txt");
        f.writeTo(os);//字节数组输出流使用writeTo方法，可以把内容转到其他类型输出流中。
        f.close();
        os.close();

    }


}
