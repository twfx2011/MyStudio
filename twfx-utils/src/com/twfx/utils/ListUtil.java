/**
 * 文件名：@ListUtil.java <br/>
 * 包名：com.twfx.utils <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;

import java.util.Collection;

/**
 * 类名：ListUtil  <br />
 *
 * 功能：List工具类
 *
 * @author twfx <br />
 * 创建时间：2016-12-30 上午08:27:16  <br />
 * @version 2016-12-30
 */
public class ListUtil {

	/**
	 * 功能：List转换为sql字符串<br/>
	 *
	 * @author twfx
	 * @version 2016-12-30 上午08:28:38 <br/>
	 */
	public static <T> String listToSQLStr(Collection<T> list) {
		if (null == list || list.size() == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (T t : list) {
			sb.append("'").append(t).append("',");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	/**
	 * 功能：List转换为以指定分隔符分隔的字符串<br/>
	 *
	 * @author twfx
	 * @version 2016-12-30 上午08:29:42 <br/>
	 */
	public static <T> String listToStr(Collection<T> list, String separator) {
		if (null == list || list.size() == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (T t : list) {
			sb.append(t).append(separator);
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	/**
	 * 功能：List转换为以逗号分隔的字符串<br/>
	 *
	 * @author twfx
	 * @version 2016-12-30 上午08:32:20 <br/>
	 */
	public static String listToStr(Collection<String> strList) {
		return listToStr(strList, ",");
	}
}
