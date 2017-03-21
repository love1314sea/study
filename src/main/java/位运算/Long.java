package 位运算;

import java.util.Arrays;

/**
 * Created by wushang on 17/3/14.
 */
public class Long {

	public static byte[] longToByteArray(long v) {
		return new byte[] {
				(byte)((v & 0xFF00000000000000L) >> 56),
				(byte)((v & 0xFF000000000000L) >> 48),
				(byte)((v & 0xFF0000000000L) >> 40),
				(byte)((v & 0xFF00000000L) >> 32),
				(byte)((v & 0xFF000000L) >> 24),
				(byte)((v & 0xFF0000L) >> 16),
				(byte)((v & 0xFF00L) >> 8),
				(byte)((v & 0xFFL)),
		};
	}

	public static byte[] longToByteArray2(long v) {
		return new byte[] {
				(byte)((v) >> 56),
				(byte)((v) >> 48),
				(byte)((v) >> 40),
				(byte)((v) >> 32),
				(byte)((v) >> 24),
				(byte)((v) >> 16),
				(byte)((v) >> 8),
				(byte)((v)),
		};
	}

	// 当 字节数组转换为数值类型,一定要考虑到负数的类型提升,并做 清除影响运算
	public static long byteArrayToLong(byte[] b) {
		return (((long)b[0] & 0xFFL) << 56)
				       | (((long)b[1] & 0xFFL) << 48)
				       | (((long)b[2] & 0xFFL) << 40)
				       | (((long)b[3] & 0xFFL) << 32)
				       | (((long)b[4] & 0xFFL) << 24)
				       | (((long)b[5] & 0xFFL) << 16)
				       | (((long)b[6] & 0xFFL) << 8)
				       | ((long)b[7] & 0xFFL);

	}

	public static void main(String[] args) {
		// 一样
		byte[] arr1 = longToByteArray(-1234567890L);
		byte[] arr2 = longToByteArray(-1234567890L);

		System.out.println(Arrays.equals(arr1, arr2));

		System.out.println(byteArrayToLong(arr2));

	}
}
