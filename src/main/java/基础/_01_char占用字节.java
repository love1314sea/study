package 基础;

/**
 * Created by wushang on 16/11/24.
 */
//参考: https://zhidao.baidu.com/question/1494586112157030859.html
import java.io.UnsupportedEncodingException;
public class _01_char占用字节{
	public static void main(String[] args){
		String str = "c";
		char x = 'c';
		byte[] bytes = null;
		byte[] bytes1 = null;
		try {
			bytes = str.getBytes("utf-8");
			bytes1 = charToByte(x);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("bytes 大小： " + bytes.length);
		//System.out.println(bytes1[1] + "\n" + bytes1[2] + "\n" + bytes1[3]);
		System.out.println("bytes1 大小： " + bytes1.length);
		System.out.println(bytes1[0] + "\n" + bytes1[1]);
	}
	public static byte[] charToByte(char c) {
		byte[] b = new byte[2];
		b[0] = (byte) ((c & 0xFF00) >> 8);
		b[1] = (byte) (c & 0xFF);
		return b;
	}
}
