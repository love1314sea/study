package IO._01_流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by wushang on 15/10/29.
 */
public class _01_读图片 {
    public static void main(String[] args) throws Exception{
        FileInputStream fs = new FileInputStream("/Users/wushang/Downloads/796987c174ac20cb6c9b15cd47bbd078.jpg");
        BufferedInputStream bs = new BufferedInputStream(fs);

        FileOutputStream fos = new FileOutputStream("./a.jpg");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int length = -1;
        while((length = bs.read( )) != -1) {
//            System.out.println((char)length);
            bos.write(length);
        }

        bs.close();
        fs.close();
        fos.close();
        bos.close();
    }
}
