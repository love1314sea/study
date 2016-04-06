package snappy;

import org.xerial.snappy.Snappy;

import java.io.IOException;
import java.util.Random;

/**
 * Created by wushang on 15/11/10.
 */
public class _01_snappy {

    private static char[] chars = "abcdefghijklmnokqrstuvwxyz123456789".toCharArray();

    private static String getRandomString() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 200; ++i) {
            int index = random.nextInt(chars.length - 1);
            stringBuilder.append(chars[index]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {

        long compTimeSum = 0;
        long decompTimeSum = 0;

        for (int i = 0; i < 100000; ++i) {
//            String str = getRandomString();
            String str = "http://www.java3z.com/cwbwebhome/article/article20/200030.html?id=4852";


            long beginTime = System.currentTimeMillis();
            byte[] compressed = Snappy.compress(str.getBytes());
            System.out.println("length=" + compressed.length);
            long compTime = System.currentTimeMillis();
            compTimeSum += (compTime - beginTime);


            byte[] uncompressed = Snappy.uncompress(compressed);
            long decompTime = System.currentTimeMillis();
            decompTimeSum += (decompTime - compTime);
        }
        System.out.println("compTimeSum =" +compTimeSum);
        System.out.println("decompTimeSum =" +decompTimeSum);

    }
}
