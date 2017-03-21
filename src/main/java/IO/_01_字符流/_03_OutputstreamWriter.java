package IO._01_字符流;

import java.io.*;

/**
 * Created by wushang on 16/12/6.
 */
public class _03_OutputstreamWriter {
	public static void main(String[] args) throws Exception{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Writer writer = new OutputStreamWriter(outputStream);

		writer.write("hello");

		writer.close();

		System.out.println(outputStream.toString());


	}
}
