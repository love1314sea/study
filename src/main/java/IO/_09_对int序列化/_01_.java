package IO._09_对int序列化;

import java.io.EOFException;

/**
 * Created by wushang on 16/1/6.
 */
public class _01_ {
    /**
     * 解码varint (zig-tag)
     * copied from avro
     * @param buf 编码字节数组
     * @return 整数值。
     * @throws EOFException
     */
    public static int decodeInt(byte[] buf) throws EOFException {
        return decodeInt(buf, 0);
    }

    /**
     * 解码varint (zig-tag)
     * copied from avro
     * @param buf 编码字节数组
     * @param pos buf中的起始位置
     * @return 整数值。
     * @throws EOFException
     */
    public static int decodeInt(byte[] buf, int pos) throws EOFException {
        int len = 1;
        int b = buf[pos] & 0xff;
        int n = b & 0x7f;
        if (b > 0x7f) {
            b = buf[pos + len++] & 0xff;
            n ^= (b & 0x7f) << 7;
            if (b > 0x7f) {
                b = buf[pos + len++] & 0xff;
                n ^= (b & 0x7f) << 14;
                if (b > 0x7f) {
                    b = buf[pos + len++] & 0xff;
                    n ^= (b & 0x7f) << 21;
                    if (b > 0x7f) {
                        b = buf[pos + len++] & 0xff;
                        n ^= (b & 0x7f) << 28;
                        if (b > 0x7f) {
                            throw new EOFException("Invalid int encoding");
                        }
                    }
                }
            }
        }
        // pos += len;
        return (n >>> 1) ^ -(n & 1); // back to two's-complement
    }

    /**
     * 使用varint编码 (zig-tag)
     * copied from avro
     * @param n 整数值
     * @return 编码后的字节数组。使用zig-tag编码，返回为长度为1-5的变长字节数组
     */
    public static byte[] encodeInt(int n) {
        byte[] buf = new byte[5];
        int pos = 0;

        // move sign to low-order bit, and flip others if negative
        n = (n << 1) ^ (n >> 31);

        if ((n & ~0x7F) != 0) {
            buf[pos++] = (byte) ((n | 0x80) & 0xFF);
            n >>>= 7;
            if (n > 0x7F) {
                buf[pos++] = (byte) ((n | 0x80) & 0xFF);
                n >>>= 7;
                if (n > 0x7F) {
                    buf[pos++] = (byte) ((n | 0x80) & 0xFF);
                    n >>>= 7;
                    if (n > 0x7F) {
                        buf[pos++] = (byte) ((n | 0x80) & 0xFF);
                        n >>>= 7;
                    }
                }
            }
        }
        buf[pos++] = (byte) n;

        byte[] b;
        if(pos == 5) {
            b = buf;
        } else {
            b = new byte[pos];
            System.arraycopy(buf, 0, b, 0, pos);
        }

        return b;
    }



    public static void main(String[] args) throws Exception{
        int i = 5;
        byte[] keyLength = encodeInt(i);

        byte[] arr = new byte[100];
        System.arraycopy(keyLength, 0, arr, 0, keyLength.length);
        byte[] str = "abc".getBytes();
        System.arraycopy(str,0, arr, keyLength.length, str.length); //虽然后面添加字符串，仍然能正常结出
        System.out.println(decodeInt(arr));
    }
}
