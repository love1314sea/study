package 字符集;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Created by wushang on 17/3/21.
 */
public class _01_Charset {

	public static void main(String[] args) {
		String s = "hello";
		byte[] bytes = s.getBytes(Charset.forName("utf-8"));


		//Charset 是NIO的,  把 字符串转换为nio的字节数组
		Charset charset = Charset.forName("utf-8");
		ByteBuffer buffer = charset.encode(s);

		CharBuffer charBuffer = charset.decode(buffer);
	}
}
