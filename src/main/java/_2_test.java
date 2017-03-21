import io.netty.buffer.ByteBuf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wushang on 16/10/25.
 */
public class _2_test {

	public static String readDataVersion(byte[] bytes) throws Exception {

		int last = 2;//0.0.0
		if (bytes[bytes.length - 1] > 0) {
			last = 3;//0.0.0.0
		}

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j <= last; j++) {
			sb.append(bytes[j]);
			if (j != last) {
				sb.append(".");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception{
		byte[] bytes = new byte[]{1,2,0,0};
		System.out.println(_2_test.readDataVersion(bytes));
	}
}
class SS {
	public String ss;
}
