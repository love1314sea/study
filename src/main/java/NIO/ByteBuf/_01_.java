package NIO.ByteBuf;

import java.nio.ByteBuffer;

/**
 * Created by wushang on 17/1/22.
 */
/*

 */
public class _01_ {
	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		System.out.println(byteBuffer.position() + ":" + byteBuffer.limit());
		byteBuffer.put((byte)1);
		byteBuffer.put((byte)2);
		System.out.println(byteBuffer.position() + ":" + byteBuffer.limit());

		byteBuffer.flip();
		System.out.println(byteBuffer.position() + ":" + byteBuffer.limit());
		System.out.println(byteBuffer.get());
		System.out.println(byteBuffer.get());
		System.out.println(byteBuffer.position() + ":" + byteBuffer.limit());

		byteBuffer.flip();
		System.out.println(byteBuffer.position() + ":" + byteBuffer.limit());
		byteBuffer.put((byte)3);
		byteBuffer.flip();
		System.out.println(byteBuffer.get());



	}
}
