/**
 * 文件名：@EncryptUtil.java <br/>
 * 包名：com.twfx.utils <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;

import java.io.IOException;
import java.security.MessageDigest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * 类名：EncryptUtil  <br />
 *
 * 功能：加密/解密算法工具类
 *
 * @author twfx <br />
 * 创建时间：2016-12-30 下午12:03:44  <br />
 * @version 2016-12-30
 */
public class EncryptUtil {

	/**
	 * 功能：MD5加密<br/>
	 *
	 * @author twfx
	 * @version 2016-12-30 下午12:04:30 <br/>
	 */
	public static String md5(String str) {
		if (null == str || str.length() == 0)
			return null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
			
			byte[] bs = messageDigest.digest();

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < bs.length; i++) {
				String hex = Integer.toHexString(0xFF & bs[i]);
				if (hex.length() == 1)
					sb.append("0");
				
				sb.append(hex);
			}

			return sb.toString().toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 功能：BASE64加密<br/>
	 *
	 * @author twfx
	 * @version 2016-12-30 下午12:16:01 <br/>
	 */
	public static String encryptBASE64(String str) {
		if (null == str || str.length() == 0)
			return null;
		return new BASE64Encoder().encode(str.getBytes());
	}
	
	/**
	 * 功能：BASE64解密<br/>
	 *
	 * @author twfx
	 * @version 2016-12-30 下午12:22:51 <br/>
	 */
	public static String decryptBASE64(String str) {
		if (null == str || str.length() == 0)
			return null;
		try {
			byte[] b = new BASE64Decoder().decodeBuffer(str);
			return new String(b);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
