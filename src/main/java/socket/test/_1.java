package socket.test;

/**
 * Created by wushang on 17/3/2.
 */
public class _1 {
	private static String readDataVersion(byte[] bytes) throws Exception {
		int i = 3;
		for( ; i>=0; i--) {
			if(bytes[i] > 0) {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int j =0; j <=i; j++) {
			sb.append(bytes[j]);
			if(j != i) {
				sb.append(".");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception{
		byte[] bytes = new byte[]{0,0,0,0};
		System.out.println(readDataVersion(bytes).length());
	}
}
