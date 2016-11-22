package service;

import java.security.MessageDigest;

public class HashCalc {

	public static String encryption(String target, String salt, String algorithm) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		messageDigest.reset();

		// SALTの追加
		messageDigest.update(salt.getBytes());

		// 暗号化
		byte[] hash = messageDigest.digest(target.getBytes());

		// 16進数変換
		StringBuffer sb = new StringBuffer();
		for (byte b : hash) {
			String str = String.format("%02x", b);
			sb.append(str);
		}
		return sb.toString();
	}

}
