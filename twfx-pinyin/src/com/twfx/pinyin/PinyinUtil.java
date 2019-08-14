/**
 * 文件名：@PinyinUtil.java <br/>
 * 包名：com.twfx.pinyin <br/>
 * 项目名：twfx-pinyin <br/>
 * @author twfx <br/>
 */
package com.twfx.pinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 类名：PinyinUtil <br />
 * 
 * 功能：汉字转拼音工具类
 * 
 * @author twfx <br />
 *         创建时间：2016-12-30 上午08:45:46 <br />
 * @version 2016-12-30
 */
public class PinyinUtil {

	/**
	 * 功能：获得指定字符串的拼音首字母<br/>
	 *
	 * @author twfx
	 * @version 2016-12-30 上午08:50:02 <br/>
	 */
	public static String getHeadChar(String str) {
		int len = str.length();
		StringBuilder convert = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char word = str.charAt(i);
			String[] pinyinArray = null;
			try {
				pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word, new HanyuPinyinOutputFormat());
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}
			if (pinyinArray != null) {
				convert.append(pinyinArray[0].charAt(0));
			} else {
				convert.append(word);
			}
		}
		return convert.toString();
	}
}
