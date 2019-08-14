/**
 * 文件名：@ArrayUtil.java <br/>
 * 包名：com.twfx.utils <br/>
 * 项目名：CommUtils <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;

import java.util.Arrays;

/**
 * 类名：ArrayUtil  <br />
 *
 * 功能：数组工具类
 *
 * @author twfx <br />
 * 创建时间：2016-12-22 下午06:07:17  <br />
 * @version 2016-12-22
 */
public class ArrayUtil {

	/**
	 * 功能：数组转换为字符串<br/>
	 *
	 * @author twfx
	 * @version 2016-12-22 下午06:07:42 <br/>
	 */
	public static <T> String arrayToStr(T[] array){
		if (null == array || array.length == 0) 
			return null;
		return Arrays.toString(array).replaceAll("[\\[\\]\\s]", "");
	}
	
	/**
	 * 功能：字符串数组转换为以逗号分隔，单引号包括的SQL字符串<br/>
	 * 如：[a, b, c]
	 * 转换后为'a','b', 'c'
	 * @author twfx
	 * @version 2016-12-22 下午06:11:22 <br/>
	 */
	public static <T> String arrayToSQLStr(T[] array) {
		if (null == array || array.length == 0) 
			return null;
		StringBuilder sb = new StringBuilder();
		for (T t : array) {
			sb.append("'").append(t).append("'").append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
}
