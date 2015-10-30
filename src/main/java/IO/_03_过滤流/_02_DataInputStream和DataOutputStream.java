package IO._03_过滤流;


import java.io.*;

public class _02_DataInputStream和DataOutputStream {
    public static void main(String[] args) throws IOException {
        //DataOutputStream 可以写基本类型数据
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("a.txt"))); //包装类，可以一层一层包装
        byte b = 5;
        int i = 10;
        char ch = 'a';
        float f = 3.14f;

        dos.writeByte(b);
        dos.writeInt(i);
        dos.writeChar(ch);
        dos.writeFloat(f);//此时打开文件是乱码，因为不是字符串，而是保留了其原来的类型信息。
        dos.close();


        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("a.txt")));
        //写和读的顺序一定要一致
        System.out.println(dis.readByte());
        System.out.println(dis.readInt());
        System.out.println(dis.readChar());
        System.out.println(dis.readFloat());
        dis.close();


    }
}
