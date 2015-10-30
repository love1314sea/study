package IO._03_过滤流;

//不能直接对外设打交道，需要对一个基本流进行包装。因此构造函数中参数都是OutputStream
//先把内容写到缓冲区

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class _01_BufferedOutputStream {
    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream("d:/aaa");
        BufferedOutputStream bos = new BufferedOutputStream(os);
        bos.write("hello girl".getBytes());

        bos.close();//关闭时会刷新缓冲区
    }
}