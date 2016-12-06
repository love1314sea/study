import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wushang on 16/10/25.
 */
public class _2_test {

	public static void main(String[] args) {
		SS s = new SS();
		s.ss = "hello world";

		String str = s.ss;
		String s1 = str.substring(0,5);
		System.out.println(s1);
		System.out.println(str);
		System.out.println(s.ss);
	}
}
class SS {
	public String ss;
}
