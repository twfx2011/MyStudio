/**
 * 文件名：@StringUtil.java <br/>
 * 包名：com.twfx.utils <br/>
 * 项目名：CommUtils <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;

/**
 * 类名：StringUtil <br />
 *
 * 功能：字符串工具类
 *
 * @author twfx <br />
 *         创建时间：2016-12-22 下午05:31:34 <br />
 * @version 2016-12-22
 */
public class StringUtil {

	/**
	 * 功能：首字母小写<br/>
	 *
	 * @author twfx
	 * @version 2017-7-16 下午06:20:43 <br/>
	 */
	public static String toLowerCaseFirstOne(String str) {
		if (null == str || str.length() == 0)
			return str;

		return new StringBuilder().append(str.substring(0, 1).toLowerCase()).append(str.substring(1)).toString();
	}

	/**
	 * 功能：首字母大写<br/>
	 *
	 * @author twfx
	 * @version 2017-7-16 下午06:20:43 <br/>
	 */
	public static String toUpperCaseFirstOne(String str) {
		if (null == str || str.length() == 0)
			return str;

		return new StringBuilder().append(str.substring(0, 1).toUpperCase()).append(str.substring(1)).toString();
	}

	/**
	 * 
	 * 功能：null转换为空<br/>
	 * 
	 * @author twfx
	 * @version 2011-9-5 上午08:41:15 <br/>
	 */
	public static String nullToEmpty(String str) {
		return isEmpty(str) ? "" : str.trim();
	}

	/**
	 * 
	 * 功能：空转换为null<br/>
	 * 
	 * @author twfx
	 * @version 2011-9-5 上午08:41:15 <br/>
	 */
	public static String emptyToNull(String str) {
		return isEmpty(str) ? null : str.trim();
	}

	/**
	 * 功能：判断是否为空<br/>
	 *
	 * @author twfx
	 * @version 2014-10-5 上午08:44:43 <br/>
	 */
	public static boolean isEmpty(String str) {
		return (null == str) || (str.trim().length() == 0);
	}

	/**
	 * 功能：为空时设置默认值<br/>
	 *
	 * @author twfx
	 * @version 2017-1-6 下午02:52:54 <br/>
	 */
	public static String emptyToVal(String str, String val) {
		return isEmpty(str) ? val : str.trim();
	}

}
