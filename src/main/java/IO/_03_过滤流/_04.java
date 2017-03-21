package IO._03_过滤流;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by wushang on 16/12/5.
 */
public class _04 {
	public static void main(String[] args) throws Exception {
		InputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("")));
	}
}
