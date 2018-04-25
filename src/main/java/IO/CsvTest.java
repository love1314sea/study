package IO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created by wushang on 2017/12/11.
 */
public class CsvTest {
	public static String checkField(String in) {
		StringBuilder sb = new StringBuilder("\"");
		int pos = in.indexOf("\"");
		while (pos > -1) {
			String before = in.substring(0, pos);
			String after = in.substring(pos + 1);
			sb.append(before).append("\"\"");
			in = after;
			if (in.length() > 0) {
				pos = in.indexOf("\"");
			} else {
				pos = -1;
			}
		}
		sb.append(in);
		sb.append("\"");
		return sb.toString();
	}

	public static void main(String[] args ) throws Exception{
		String file = "a.csv";
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "GB2312"), 1024);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		writer.write(checkField("6346260035962050000,abc,\"def\"hi\""));
		writer.write("6346260035962050000"+"\t");


		writer.close();
	}
}
