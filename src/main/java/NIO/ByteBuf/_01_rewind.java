package NIO.ByteBuf;

import java.nio.CharBuffer;

public class _01_rewind {

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(2);
        buffer.put('a');
        buffer.put('b');
        buffer.rewind();
        buffer.put('c');
        buffer.flip();
        System.out.println(buffer.get());
    }
}
