package lz4;

import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import net.jpountz.lz4.LZ4SafeDecompressor;

import java.io.UnsupportedEncodingException;

/**
 * Created by wushang on 15/11/10.
 */
public class _2 {
    public static void  main(String[] args) throws UnsupportedEncodingException {
        LZ4Factory factory = LZ4Factory.fastestInstance();

        byte[] data = "12345345234572add".getBytes("UTF-8");
        final int decompressedLength = data.length;

        //1 字节数组－》获得未压缩时，字节数组长度
        // 获得压缩对象 －》根据未压缩时长度，获得压缩后的长度－》定义字节数组－》压缩
// compress data
        LZ4Compressor compressor = factory.fastCompressor();
        int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
        byte[] compressed = new byte[maxCompressedLength];
        int compressedLength = compressor.compress(data, 0, decompressedLength, compressed, 0, maxCompressedLength);

// decompress data
// - method 1: when the decompressed length is known
        LZ4FastDecompressor decompressor = factory.fastDecompressor();
        byte[] restored = new byte[decompressedLength];
        int compressedLength2 = decompressor.decompress(compressed, 0, restored, 0, decompressedLength);
        System.out.println(new String(restored));
// compressedLength == compressedLength2

// - method 2: when the compressed length is known (a little slower)
// the destination buffer needs to be over-sized
        LZ4SafeDecompressor decompressor2 = factory.safeDecompressor();
        int decompressedLength2 = decompressor2.decompress(compressed, 0, compressedLength, restored, 0);
        System.out.println(new String(restored));

// decompressedLength == decompressedLength2
    }
}
