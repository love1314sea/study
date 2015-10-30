package IO._01_字符流;
//字符流的基类是Reader和Writer,是字节流和字符流转换的桥梁。读，字节流-》字符流；写，字符流-》字节流

import java.io.*;

public class _01_BufferedWriter和BufferedReader {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("a.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos); //字节流-》字符流
        BufferedWriter bw = new BufferedWriter(osw); //再一次包装
        bw.write("google.com\n");
        bw.write("baidu.com");
        bw.close();

        FileInputStream fis = new FileInputStream("a.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while(null != line) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
    }
}
