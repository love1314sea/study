package hbase;

/**
 * Created by wushang on 16/9/1.
 */
public class _01_ {
	public static void main(String[] args) {

		int rlength = 32768;
		System.out.println((short)(rlength & 0x0000ffff));
	}
}
