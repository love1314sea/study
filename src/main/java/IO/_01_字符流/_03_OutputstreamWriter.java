package IO._01_字符流;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by wushang on 16/12/6.
 */
public class _03_OutputstreamWriter {
	public static void main(String[] args) throws Exception{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Writer writer = new OutputStreamWriter(outputStream, Charset.forName("utf-8"));

		writer.write("hello");

		writer.close();

		System.out.println(outputStream.toString());


	}
}
