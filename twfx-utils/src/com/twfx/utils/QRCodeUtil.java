/**
 * 文件名：@QRCodeUtil.java <br/>
 * 包名：com.mescs.baseinfo.utils <br/>
 * 项目名：mescs-baseinfo <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;


/**
 * 类名：QRCodeUtil  <br />
 *
 * 功能：二维码生成工具类
 *
 * @author twfx <br />
 * 创建时间：2017年8月24日 上午8:19:33  <br />
 * @version 2017年8月24日
 */
public class QRCodeUtil {
	
	/**
	 * 功能：检查字符串是否合法<br/>
	 *
	 * @author twfx
	 * @version 2017年8月24日 上午10:56:34 <br/>
	 */
	public static boolean checkValid(String str) {
		if (null != str && str.length() > 0) {
			String s = str.substring(0, str.length() - 1);
			String checkBit = str.substring(str.length() - 1);
			String b = getCheckBit(s);
			if (b.equals(checkBit)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 功能：解析显示二维码编码<br/>
	 *
	 * @author twfx
	 * @version 2017年8月24日 上午11:54:02 <br/>
	 */
	public static String[] parseQRShowCode(String showCode, int decimalBit) {
		String[] array = new String[2];
		array[0] = showCode.substring(0, 7); // 物料编号
		String zs = showCode.substring(7, 10); // 整数部分
		String xs = showCode.substring(10, 11); // 小数部分
		if (decimalBit == 2) {
			xs = showCode.substring(10, 12); // 小数部分
		}
		array[1] = Integer.parseInt(zs) + "." + xs;
		return array;
	}
	
	/**
	 * 功能：生成二维码<br/>
	 *
	 * @author twfx
	 * @version 2017年8月24日 上午8:22:02 <br/>
	 */
	public static String getQRCode(String code, String materialId, String weight) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(code);
		sb.append(getQRShowCode(materialId, weight));
		return sb.toString();
	}
	
	/**
	 * 功能：二维码显示号<br/>
	 *
	 * @author twfx
	 * @version 2017年8月24日 上午9:52:40 <br/>
	 */
	public static String getQRShowCode(String materialId, String weight) {
		StringBuilder sb = new StringBuilder();
		sb.append(materialId);
		String[] ws = weight.split("\\.");
		sb.append(String.format("%03d", Integer.parseInt(ws[0])));
		if (ws.length >= 2) {
			int decimalLen = ws[1].length();
			if (decimalLen < 2) {
				sb.append(ws[1] + String.format("%1$0"+(2-ws[1].length())+"d",0));
			}else if (decimalLen == 2){
				sb.append(ws[1]);
			}else {
				sb.append(ws[1].substring(0, 2));
			}
		}else {
			sb.append("00");
		}
		
		sb.append(getCheckBit(sb.toString()));
		
		return sb.toString();
	}
	
	/**
	 * 功能：加权取余法<br/>
	 *
	 * @author twfx
	 * @version 2017年8月24日 上午10:17:40 <br/>
	 */
	public static String getCheckBit(String str) {
		// 权因子:质数
		int[] weightFactor = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
		int modulus = 9; // 模数
		if (null != str && str.length() > 0) {
			String[] ss = str.split("");
			int sum = 0;
			for (int i = 0; i < ss.length; i ++) {
				String s = ss[i];
				int wv = Integer.parseInt(s) * weightFactor[i];
				sum += wv;
			}
			
			int remainder = sum % modulus; 
            int checkBit = modulus - remainder;  
			
			return String.valueOf(checkBit);
		}
		
		return null;
	}
}
