package lz4;

import javafx.beans.binding.StringBinding;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import net.jpountz.lz4.LZ4SafeDecompressor;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Created by wushang on 15/11/10.
 */
public class _01_lz4 {
    private static char[] chars = "abcdefghijklmnokqrstuvwxyz123456789".toCharArray();

    private static final LZ4Factory factory;
    private static final LZ4Compressor compressor;
    private static final LZ4FastDecompressor decompressor;
    private static final LZ4SafeDecompressor decompressor2;

    static {
        factory = LZ4Factory.fastestInstance();
        compressor = factory.fastCompressor();
        decompressor = factory.fastDecompressor();
        decompressor2 = factory.safeDecompressor();
    }

    private static String getRandomString() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 200; ++i) {
            int index = random.nextInt(chars.length - 1);
            stringBuilder.append(chars[index]);
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) throws UnsupportedEncodingException {

        long compTimeSum = 0;
        long decomp1TimeSum = 0;
        long decomp2TimeSum = 0;

        for(int i=0; i<100000; ++i) {
            String str = getRandomString();
//            String str = "http://www.java3z.com/cwbwebhome/article/article20/200030.html?id=4852";
//            String str = "https://www.baidu.com/s?wd=BlockingQueue&rsv_spt=1&rsv_iqid=0xed93929000002c54&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=2";
//              String str = "add";
//            System.out.println(str);

            byte[] data = str.getBytes("UTF-8");
            System.out.println("data length = " + data.length);
            final int decompressedLength = data.length;
            int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
            byte[] compressed = new byte[maxCompressedLength];
            //压缩
            long beginTime = System.currentTimeMillis();
            int compressedLength = compressor.compress(data, 0, decompressedLength, compressed, 0, maxCompressedLength);
            System.out.println("length=" + compressedLength);

            long compTime = System.currentTimeMillis();
            compTimeSum += (compTime - beginTime);

            byte[] restored = new byte[decompressedLength];

            long beginCompTime = System.currentTimeMillis();
            int compressedLength2 = decompressor.decompress(compressed, 0, restored, 0, decompressedLength);
            long decomp1Time = System.currentTimeMillis();
            decomp1TimeSum += (decomp1Time - beginCompTime);

            int decompressedLength2 = decompressor2.decompress(compressed, 0, compressedLength, restored, 0);
            long decomp2Time = System.currentTimeMillis();
            decomp2TimeSum += (decomp2Time - decomp1Time);
        }
        System.out.println("compTimeSum =" +compTimeSum);
        System.out.println("decomp1TimeSum =" +decomp1TimeSum);
        System.out.println("decomp2TimeSum =" +decomp2TimeSum);



    }
}
