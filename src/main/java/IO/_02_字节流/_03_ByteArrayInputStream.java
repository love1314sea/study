package IO._02_字节流;

import java.io.ByteArrayInputStream;
import java.io.IOException;

//输入源是一个字节数组
public class _03_ByteArrayInputStream {
    public static void main(String[] args) throws IOException {
        String str = "abc";
        byte[] b = str.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(b); //
        int c;
        while(-1 != (c = in.read())) {
            System.out.println((char)c);
        }
        in.reset();//重新回到起点

        byte[] dest = new byte[b.length];
        in.read(dest, 0, b.length);
//        in.read(dest);
        System.out.println("dest=" + new String(dest));
        in.close();
    }
}
