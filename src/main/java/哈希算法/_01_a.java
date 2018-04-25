package 哈希算法;


import com.clearspring.analytics.hash.MurmurHash;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by wushang on 2017/6/15.
 */
public class _01_a {

	public static void main(String[] args) throws Exception {


		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/wushang/Downloads/data/did.txt")));
		BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./hash-1")));
		String line = br.readLine().trim();
		while (null != line) {
//			System.out.println(line);
			long l = Long.valueOf(line);
			int hashId = (int) (l << 8);
			bw1.write(Math.abs(hashId) + "\n");
			line = br.readLine().trim();
		}
		bw1.flush();
		br.close();
		bw1.close();

	}
}
