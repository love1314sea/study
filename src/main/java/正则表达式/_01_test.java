package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wushang on 2017/6/27.
 */
public class _01_test {

	public static void main(String[] args) {
		Pattern eqSeparatedOpt = Pattern.compile("(--[^=]+)=(.+)");
		String arg = "--master spark://207.184.161.138:6066";
		String value = null;
		Matcher m = eqSeparatedOpt.matcher(arg);
		if (m.matches()) {
			arg = m.group(1);
			value = m.group(2);
		}
		System.out.println("arg=" + arg);
		System.out.println("value=" + value);
	}
}
