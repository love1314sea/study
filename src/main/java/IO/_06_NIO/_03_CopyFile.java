package IO._06_NIO;

/*
使用了FileInputStream、FileOutputStream、FileChannel对文件进行拷贝
输入流和输出流都接channal
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class _03_CopyFile {
    public static void main(String[] args) throws Exception {
//        String infile = "C:\\copy.sql";
        String infile = "/Users/wushang/Downloads/active_source/part-00000";
        String outfile = "/Users/wushang/Downloads/active_source/part-00000-bak";
        // 获取源文件和目标文件的输入输出流
        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);
        // 获取输入输出通道
        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();
        // 创建缓冲区

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long startTs = System.currentTimeMillis();
        while (true) {
            // clear方法重设缓冲区，使它可以接受读入的数据
            buffer.clear();
            // 从输入通道中将数据读到缓冲区
            int r = fcin.read(buffer);
            // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
            if (r == -1) {
                break;
            }
            // flip方法让缓冲区可以将新读入的数据写入另一个通道
            buffer.flip();
            // 从输出通道中将数据写入缓冲区
            fcout.write(buffer);
        }
//        duration=6751
//        duration=34030

//        http://blog.csdn.net/bruce128/article/details/17338481
        System.out.println("duration=" + (System.currentTimeMillis() - startTs));
    }
}