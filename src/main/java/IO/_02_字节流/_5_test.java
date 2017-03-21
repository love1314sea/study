package IO._02_字节流;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by wushang on 17/1/8.
 */
public class _5_test {
	public static void main(String[] args) {
		byte[] bytes = null;
		ByteArrayOutputStream os = new ByteArrayOutputStream(1);
		os.write(-5);
		bytes = os.toByteArray();
		System.out.println(bytes[0]);

		int b = bytes[0];
		System.out.println(b);

		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		System.out.println(bis.read());//251
		System.out.println(bis.read());//-1
	}
}
