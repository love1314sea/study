package 加密.TEA;

import java.io.IOException;

/**
 * Created by wushang on 17/3/1.
 */
public class Base64 {
	public static String encode(byte[] bstr){
		return new sun.misc.BASE64Encoder().encode(bstr);
	}

	/**
	 * 解码
	 * @param str
	 * @return string
	 */
	public static byte[] decode(String str){
		byte[] bt = null;
		try {
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			bt = decoder.decodeBuffer( str );
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bt;
	}

	public static void main(String[] args) {
		System.out.println(decode("aaafsfsfsfsdfsfsdfsfsfsfsfsfs").length);
	}
}
