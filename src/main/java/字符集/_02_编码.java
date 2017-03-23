package 字符集;

/**
 * Created by wushang on 17/3/21.
 */
public class _02_编码 {
	public static void main(String[] args) throws Exception{
		String name = "I am 君山";
		name.toCharArray();

		byte[] iso8859 = name.getBytes("ISO-8859-1");

		System.out.println(iso8859.length);//7

		byte[] utf16 = name.getBytes("utf-16");
		System.out.println(utf16.length);//16
		System.out.println(bytesToHexString(utf16));
	}

	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
}
