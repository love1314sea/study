package BloomFilter.demo2.bean;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import com.google.common.hash.PrimitiveSink;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by wushang on 15/7/21.
 */
public class BloomFilterBean {

    private BloomFilter<CharSequence> bf;
    private String name;
    private static Charset utf8 = Charset.forName("utf-8");

    public BloomFilterBean() {
        bf = BloomFilter.create(Funnels.stringFunnel(utf8), 1, 0.01);
    }

    public Boolean mightContians(String key) {
        return bf.mightContain(key);
    }

//    public Byte[] toBytes() {
////        bf.wr
//    }

    public byte[] serialize() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bf.writeTo(baos);
        baos.close();
        return baos.toByteArray();
    }

    public BloomFilter<CharSequence> deserialize(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        BloomFilter<CharSequence> bf = BloomFilter.readFrom(bais, Funnels.stringFunnel(utf8));
        bais.close();
        return bf;
    }


}
