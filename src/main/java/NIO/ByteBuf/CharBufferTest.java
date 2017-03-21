package NIO.ByteBuf;

import java.nio.CharBuffer;

/**
 * Created by wushang on 17/1/23.
 */
public class CharBufferTest {
	public static void main(String[] args) {

		char[] chars = new char[10];//受到影响
		chars[0] = 'a';
		CharBuffer buffer = CharBuffer.wrap(chars);
		buffer.put('b');
		buffer.flip();
		System.out.println(buffer.get());
		System.out.println(chars[0]);
	}
}
