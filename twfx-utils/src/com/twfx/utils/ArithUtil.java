/**
 * 文件名：@ArithUtil.java <br/>
 * 包名：com.twfx.utils <br/>
 * 项目名：CommUtils <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * 类名：ArithUtil <br />
 * 
 * 功能：算术工具类
 * 
 * 由于Java的简单类型不能够精确的对浮点数进行运算， 这个工具类提供精 确的浮点数运算，包括加减乘除和四舍五入。
 * 
 * @author twfx <br />
 *         创建时间：2016-12-22 下午06:31:29 <br />
 * @version 2016-12-22
 */
public class ArithUtil {

	/** 保留小数位 */
	private static final int DEF_DIV_SCALE = 10;
	/**
	 * 功能：两个Double数相加<br/>
	 * 
	 * @author twfx
	 * @version 2016-12-22 下午06:34:24 <br/>
	 */
	public static Double add(Double d1, Double d2) {
		BigDecimal bd1 = new BigDecimal(d1.toString());
		BigDecimal bd2 = new BigDecimal(d2.toString());
		return bd1.add(bd2).doubleValue();
	}

	/**
	 * 功能：两个String数相加<br/>
	 * 
	 * @author twfx
	 * @version 2016-12-22 下午06:36:52 <br/>
	 */
	public static String add(String s1, String s2) {
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		return bd1.add(bd2).toString();
	}

	/**
	 * 功能：两个String数相加，四舍五入保留scale位小数<br/>
	 * 
	 * @author twfx
	 * @version 2016-12-22 下午06:37:34 <br/>
	 */
	public static String add(String s1, String s2, int scale) {
		if (scale < 0)
			throw new IllegalArgumentException("保留小数位不能为负数！");
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		bd1 = bd1.add(bd2);
		return bd1.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 功能：两个Double数相减<br/>
	 *
	 * @author twfx
	 * @version 2016-12-22 下午06:41:17 <br/>
	 */
	public static Double sub(Double d1, Double d2) {
		BigDecimal bd1 = new BigDecimal(d1.toString());
		BigDecimal bd2 = new BigDecimal(d2.toString());
		return bd1.subtract(bd2).doubleValue();
	}
	
	/**
	 * 功能：两个String数相减<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 上午08:11:05 <br/>
	 */
	public static String sub(String s1, String s2) {
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		return bd1.subtract(bd2).toString();
	}

	/**
	 * 功能：两个String数相减，四舍五入保留scale位小数<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 上午08:11:59 <br/>
	 */
	public static String sub(String s1, String s2, int scale) {
		if (scale < 0)
			throw new IllegalArgumentException("保留小数位不能为负数！");
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		bd1 = bd1.subtract(bd2);
		return bd1.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 功能：两个Double数相乘<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 上午08:20:38 <br/>
	 */
	public static Double mul(Double d1, Double d2) {
		BigDecimal bd1 = new BigDecimal(d1.toString());
		BigDecimal bd2 = new BigDecimal(d2.toString());
		return bd1.multiply(bd2).doubleValue();
	}

	/**
	 * 功能：两个String数相乘<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 上午08:22:28 <br/>
	 */
	public static String mul(String s1, String s2) {
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		return bd1.multiply(bd2).toString();
	}

	/**
	 * 功能：两个String数相乘，四舍五入保留scale位小数<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 上午08:26:05 <br/>
	 */
	public static String mul(String s1, String s2, int scale) {
		if (scale < 0)
			throw new IllegalArgumentException("保留小数位不能为负数！");
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal db2 = new BigDecimal(s2);
		bd1 = bd1.multiply(db2);
		return bd1.setScale(scale, RoundingMode.HALF_UP).toString();
	}

	/**
	 * 功能：两个String数相乘，四舍五入保留scale位小数，返还double类型<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午03:32:53 <br/>
	 */
	public static double mulDouble(String s1, String s2, int scale) {
		if (scale < 0)
			throw new IllegalArgumentException("保留小数位不能为负数！");
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		bd1 = bd1.multiply(bd2);
		return (bd1.setScale(scale, RoundingMode.HALF_UP)).doubleValue();
	}

	/**
	 * 功能：两个String数相乘，四舍五入保留scale位小数，返还float类型<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午03:35:04 <br/>
	 */
	public static float mulFloat(String s1, String s2, int scale) {
		if (scale < 0)
			throw new IllegalArgumentException("保留小数位不能为负数！");
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		bd1 = bd1.multiply(bd2);
		return (bd1.setScale(scale, RoundingMode.HALF_UP)).floatValue();
	}

	/**
	 * 功能：两个Double数相乘，四舍五入<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午03:37:18 <br/>
	 */
	public static Double div(Double d1, Double d2) {
		BigDecimal bd1 = new BigDecimal(d1.toString());
		BigDecimal bd2 = new BigDecimal(d2.toString());
		return bd1.divide(bd2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 功能：两个Double数相除，四舍五入保留scale位小数<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午03:40:23 <br/>
	 */
	public static Double div(Double d1, Double d2, int scale) {
		if (scale < 0)
			throw new IllegalArgumentException("保留小数位不能为负数！");
		BigDecimal bd1 = new BigDecimal(d1.toString());
		BigDecimal bd2 = new BigDecimal(d2.toString());
		return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 功能：两个String数相乘，四舍五入<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午03:41:49 <br/>
	 */
	public static String div(String s1, String s2) {
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		return bd1.divide(bd2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 功能：两个String数相除，四舍五入保留scale位小数<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午03:42:36 <br/>
	 */
	public static String div(String s1, String s2, int scale) {
		if (scale < 0)
			throw new IllegalArgumentException("保留小数位不能为负数！");
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 功能：两个String数相除，四舍五入保留scale位小数，返还double类型<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午03:32:53 <br/>
	 */
	public static double divDouble(String d1, String d2, int scale) {
		if (scale < 0)
			throw new IllegalArgumentException("保留小数位不能为负数！");
		BigDecimal bd1 = new BigDecimal(d1);
		BigDecimal bd2 = new BigDecimal(d2);
		return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 功能：两个String数相除，四舍五入保留scale位小数，返还float类型<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午03:44:50 <br/>
	 */
	public static float divFloat(String s1, String s2, int scale) {
		if (scale < 0)
			throw new IllegalArgumentException("保留小数位不能为负数！");
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).floatValue();
	}

	/**
	 * 功能：将String字符串四舍五入并保留scale位小数<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午03:45:53 <br/>
	 */
	public static String scale(String s, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("保留小数位不能为负数！");
		}
		BigDecimal bd = new BigDecimal(s);
		return bd.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 功能：将String字符串截去并保留scale位小数<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午03:47:11 <br/>
	 */
	public static String scaleDown(String s, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("保留小数位不能为负数！");
		}
		BigDecimal bd = new BigDecimal(s);
		return bd.setScale(scale, BigDecimal.ROUND_DOWN).toString();
	}

	/**
	 * 功能：将String字符串转换为百分比，并四舍五入保留scale位小数<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午03:50:40 <br/>
	 */
	public static String percent(String s, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("保留小数位不能为负数！");
		}
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMaximumFractionDigits(scale);
		return nf.format(Double.parseDouble(s));
	}

	/**
	 * 功能：两个String相除，保留scale位小数，向下舍去<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午03:55:34 <br/>
	 */
	public static String divDown(String s1, String s2, int scale) {
		if (scale < 0)
			throw new IllegalArgumentException("保留小数位不能为负数！");
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		return bd1.divide(bd2, scale, BigDecimal.ROUND_DOWN).toString();
	}

	/**
	 * 功能：两个String数相乘，保留scale位小数，向下舍去<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午04:13:31 <br/>
	 */
	public static String mulDown(String s1, String s2, int scale) {
		if (scale < 0)
			throw new IllegalArgumentException("保留小数位不能为负数！");
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		bd1 = bd1.multiply(bd2);
		return bd1.setScale(scale, RoundingMode.FLOOR).toString();
	}

	/**
	 * 功能：两个String数相加，保留scale位小数，向下舍去<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午04:17:07 <br/>
	 */
	public static String addDown(String s1, String s2, int scale) {
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		bd1 = bd1.add(bd2);
		return bd1.setScale(scale, BigDecimal.ROUND_DOWN).toString();
	}

	/**
	 * 功能：两个String数相减，保留scale位小数，向下舍去<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午04:25:14 <br/>
	 */
	public static String subDown(String s1, String s2, int scale) {
		if (scale < 0)
			throw new IllegalArgumentException("保留小数位不能为负数！");
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		bd1 = bd1.subtract(bd2);
		return bd1.setScale(scale, BigDecimal.ROUND_DOWN).toString();
	}

	/**
	 * 功能：两个String数比较大小<br/>
	 *
	 * @author twfx
	 * @version 2016-12-23 下午04:27:24 <br/>
	 */
	public static int comparison(String s1, String s2) {
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		return bd1.compareTo(bd2);
	}
}
