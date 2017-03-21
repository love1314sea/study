package NIO;

import org.jboss.netty.util.internal.ByteBufferUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

/**
 * Created by wushang on 17/1/25.
 */
public class _01_字节顺序 {
	public static void main(String[] args) {
		System.out.println(ByteOrder.nativeOrder());

		System.out.println(ByteOrder.BIG_ENDIAN);
		System.out.println(ByteOrder.LITTLE_ENDIAN);

		System.out.println(ByteBuffer.allocate(1).order());
		System.out.println(CharBuffer.allocate(1).order());
	}
}
