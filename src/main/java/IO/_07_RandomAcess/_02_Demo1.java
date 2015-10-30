package IO._07_RandomAcess;
/*
1 既可以读文件也可以写文件
2 java硬盘上的文件都是字节数组模型
3 文件指针，刚打开时指针在开头，pointer = 0
4 写write(int),只写一个字节（后8位），同时指针执行下一个字节位置，准备写入
5 read() :读一个字节

 */

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class _02_Demo1 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\text","rw");
        System.out.println(raf.getFilePointer());//开始为0
        raf.write(97); //只写一个字节，把int的低8位写入,后8位已经能表示它
        System.out.println(raf.getFilePointer());//写入一个字节，指向1
        raf.write('A');
        System.out.println(raf.getFilePointer());//指向2

        int i = 0x7fffffff;
        raf.write(i >>> 24 ); //右移，高位补0，把高8位写入
        raf.write(i >>> 16 );
        raf.write(i >>> 8 );
        raf.write(i);

        raf.writeInt(i); // 写一个整数，实际上调用了上面的移位的方法

        String s = "中";//java字符串中是utf-16be编码
        raf.write(s.getBytes("gbk"));//转换成字节数组，再写进去

        System.out.println("length=" + raf.length());
        //读----------------------------
        byte[] bytes = new byte[(int)raf.length()];
        raf.seek(0); //不要忘记移动指针

        raf.read(bytes);//读
        System.out.println(Arrays.toString(bytes));//输出每个字节的值

        String s1 = new String(bytes,"gbk");//转换成字符串输出，使用gbk编码
        System.out.println(s1);//仍会是乱码，因为我们无规律的输入了很多，解析时会乱

        for(byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        raf.close();

    }
}
