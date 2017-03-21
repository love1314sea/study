package 加密.AES;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * Created by wushang on 17/2/27.
 */
public class AESUtil {

	private static final String ENCRYPT_NAME = "AES";
	private static final String SECRET_ALGORITHM = "SHA1PRNG";
	private static final byte[] KEY = "abcdefg".getBytes();

	/**
	 * AES加密
	 *
	 * @param content    待加密的内容
	 * @param encryptKey 加密密钥
	 * @return 加密后的byte[]
	 * @throws Exception
	 */
	public static String aesEncrypt(String content, String encryptKey) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance(ENCRYPT_NAME);
		SecureRandom random = SecureRandom.getInstance(SECRET_ALGORITHM);
		random.setSeed(encryptKey.getBytes());
		kgen.init(128, random);

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));

		return byteArr2HexStr(cipher.doFinal(content.getBytes("utf-8")));
	}

	public static byte[] encrypt(byte[] content) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance(ENCRYPT_NAME);
		SecureRandom random = SecureRandom.getInstance(SECRET_ALGORITHM);
		random.setSeed(KEY);
		kgen.init(128, random);

		Cipher cipher = Cipher.getInstance(ENCRYPT_NAME);
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), ENCRYPT_NAME));

		return cipher.doFinal(content);
	}

	/**
	 * AES解密
	 *
	 * @param encryptBytes 待解密的byte[]
	 * @param decryptKey   解密密钥
	 * @return 解密后的String
	 * @throws Exception
	 */
	public static String aesDecrypt(byte[] encryptBytes, String decryptKey) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance(ENCRYPT_NAME);
		SecureRandom random = SecureRandom.getInstance(SECRET_ALGORITHM);
		random.setSeed(decryptKey.getBytes());
		kgen.init(128, random);


		Cipher cipher = Cipher.getInstance(ENCRYPT_NAME);
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), ENCRYPT_NAME));
		byte[] decryptBytes = cipher.doFinal(encryptBytes);

		return new String(decryptBytes, "utf-8");
	}

	public static byte[] decrypt(byte[] encryptBytes) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance(ENCRYPT_NAME);
		SecureRandom random = SecureRandom.getInstance(SECRET_ALGORITHM);
		random.setSeed(KEY);
		kgen.init(128, random);
		Cipher cipher = Cipher.getInstance(ENCRYPT_NAME);
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), ENCRYPT_NAME));
		byte[] decryptBytes = cipher.doFinal(encryptBytes);
		return decryptBytes;
	}

	//随机生成密钥
	private static String getKey() throws Exception {
		//       DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 为我们选择的DES算法生成一个KeyGenerator对象
		KeyGenerator kg = KeyGenerator.getInstance(ENCRYPT_NAME);
		kg.init(sr);
		// 生成密匙
		SecretKey key = kg.generateKey();
		// 获取密匙数据
		byte rawKeyData[] = key.getEncoded();

		//return new String(rawKeyData);

		return byteArr2HexStr(rawKeyData);
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		String content = "我爱你";
		System.out.println("加密前：" + content);

		String key = "123456890";
		key = getKey();
		System.out.println("加密密钥和解密密钥：" + key);

		String encrypt = aesEncrypt(content, key);
		System.out.println("加密后：" + encrypt);

		String decrypt = aesDecrypt(hexStr2ByteArr(encrypt), key);
		System.out.println("解密后：" + decrypt);

		byte[] bytes = new byte[]{8, 18};
		System.out.println(byteArr2HexStr(bytes));
		System.out.println(bytesToHexString(bytes));

	}


	/**
	 * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
	 * hexStr2ByteArr(String strIn) 互为可逆的转换过程
	 *
	 * @param arrB 需要转换的byte数组
	 * @return 转换后的字符串
	 * @throws Exception 本方法不处理任何异常，所有异常全部抛出
	 */
	private static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 把负数转换为正数
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**
	 * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)
	 * 互为可逆的转换过程
	 *
	 * @param strIn 需要转换的字符串
	 * @return 转换后的byte数组
	 * @throws Exception 本方法不处理任何异常，所有异常全部抛出
	 */
	private static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
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
