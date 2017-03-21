package gzip;

/**
 * Created by wushang on 17/2/22.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

// 将一个字符串按照zip方式压缩和解压缩
public class _01_test {


	public static byte[] compress(byte[] src) throws IOException {
		if (src == null || src.length == 0) {
			return new byte[0];
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(src);
		gzip.close();
		return out.toByteArray();
	}

	// 解压缩, 最好不要返回null, 在生产环境中注意
	public static byte[] uncompress(byte[] src) throws IOException {
		if (src == null || src.length == 0) {
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		ByteArrayInputStream in = new ByteArrayInputStream(src);
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[256];
		int len = -1;
		while ((len = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, len);
		}
		gunzip.close();
		out.close();
		return out.toByteArray();

	}

	// 测试方法
	public static void main(String[] args) throws IOException {

		//测试字符串
//		String str = "%5B%7B%22lastUpdateTime%22%3A%222011-10-28+9%3A39%3A41%22%2C%22smsList%22%3A%5B%7B%22liveState%22%3A%221";
		String str = "hellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohello";

		byte[] src = str.getBytes();
		System.out.println("压缩前:" + src.length);
		byte[] dest = compress(src);
		System.out.println("压缩后:" + dest.length);
		System.out.println("解压:" + new String(uncompress(dest)));



	}

}
