package IO._03_过滤流;

import java.io.*;

/**
 * Created by wushang on 16/9/26.
 */
public class _03_BufferedInputStream {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream(""); //读取这个文件
		BufferedInputStream bis = new BufferedInputStream(is);//使用buffer

		OutputStream os = new FileOutputStream(""); //写到这个文件中
		BufferedOutputStream bos = new BufferedOutputStream(os);//使用buffer
		byte[] flush = new byte[1024];
		int len = 0;
		while (-1 != (len = bis.read(flush))) {
			bos.write(flush, 0, len);

		}
		bos.flush();

		bis.close();
		bos.close();

	}
}
