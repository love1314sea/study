package 加密.TEA;

import java.util.Random;

/**
 * Created by wushang on 17/2/23.
 */
public class TeaTest {
	Tea tea = new Tea();
	char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h','i','j','k','l','m','n','o','p','q', '涨', '三', '需', '要', '填', '充', '的', '位', '数'};
	Random random = new Random();


	public void testEncryptByTea() throws Exception {

		for(int i=0; i<10000; ++i) {
			String str = getRandomStr();
//			System.out.println("加密前:" + str);
			byte[] secretInfo = tea.encryptByTea(str);

			String res = tea.decryptByTea(secretInfo);
			if(!str.equals(res)) {
				System.out.println(res);
			} else {
//				System.out.println("yes");
			}
		}


	}

	private String getRandomStr() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			int r = random.nextInt(chars.length);
			stringBuilder.append(chars[r]);
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) throws Exception {
		TeaTest teaTest = new TeaTest();
		teaTest.testEncryptByTea();
	}
}
