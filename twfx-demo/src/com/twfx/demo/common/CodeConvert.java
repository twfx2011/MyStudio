/**
 * 文件名：@CodeConvert.java <br/>
 * 包名：com.twfx.demo.common <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.common;

import java.io.UnsupportedEncodingException;

/**
 * 类名：CodeConvert  <br />
 *
 * 功能：字符串编码转换
 *
 * @author twfx <br />
 * 创建时间：2019年7月31日 上午8:22:29  <br />
 * @version 2019年7月31日
 */
public class CodeConvert {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str = "abcd";
		str = new String(str.getBytes("GB2312"), "ISO8859_1");
		
		System.out.println(str);
	}
}
