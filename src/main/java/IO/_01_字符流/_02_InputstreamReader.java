package IO._01_字符流;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by wushang on 16/12/6.
 */
public class _02_InputstreamReader {
	public static void main(String[] args) throws Exception{
		InputStreamReader reader = new InputStreamReader(new FileInputStream("/Users/wushang/IdeaProjects/toyprogram/study/src/main/java/IO/_01_字符流/_02_InputstreamReader.java"), Charset.forName("utf-8"));

		System.out.println(reader.read());


		char[] chars = new char[10];
		int i = 0;
		while ( (i = reader.read(chars,0,chars.length)) != -1) {
			System.out.println(new String(chars));
		}
		reader.close();
	}
}