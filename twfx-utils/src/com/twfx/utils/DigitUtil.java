/**
 * 文件名：@DigitUtil.java <br/>
 * 包名：com.twfx.utils <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;

/**
 * 类名：DigitUtil  <br />
 *
 * 功能：数字工具类
 *
 * @author twfx <br />
 * 创建时间：2016-12-30 上午09:13:55  <br />
 * @version 2016-12-30
 */
public class DigitUtil {

	/**
	 * 功能：获得指定字符串的数据大写<br/>
	 *
	 * @author twfx
	 * @version 2016-12-30 上午09:14:16 <br/>
	 */
	public static String getDigitUpper(String str){
 		if (null == str || str.length() == 0)
 			return "";
 		if (!isDouble(str)) {
 			throw new NumberFormatException("非法数字！");
 		}
 		double n = Double.parseDouble(str);
        String fraction[] = {"角", "分"};
        String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String unit[][] = {{"元", "万", "亿"}, {"", "拾", "佰", "仟"}};
 
        String head = n < 0? "负": "";
        n = Math.abs(n);
         
        String s = "";
        for (int i = 0; i < fraction.length; i++) {
            s += (digit[(int)(Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
        }
        if(s.length()<1){
            s = "整";    
        }
        int integerPart = (int)Math.floor(n);
 
        for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
            String p ="";
            for (int j = 0; j < unit[1].length && n > 0; j++) {
                p = digit[integerPart%10]+unit[1][j] + p;
                integerPart = integerPart/10;
            }
            s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
        }
        return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
    }
	
	/**
	 * 功能：判断是否为整数<br/>
	 *
	 * @author twfx
	 * @version 2015年4月9日 下午3:16:32 <br/>
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * 功能：判断是否为数字<br/>
	 *
	 * @author twfx
	 * @version 2015年4月9日 下午3:37:05 <br/>
	 */
	public static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
