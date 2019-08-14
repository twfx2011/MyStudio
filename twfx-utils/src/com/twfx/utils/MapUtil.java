/**
 * 文件名：@MapUtil.java <br/>
 * 包名：com.twfx.utils <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名：MapUtil  <br />
 *
 * 功能：Map工具类
 *
 * @author twfx <br />
 * 创建时间：2016-12-30 上午09:30:59  <br />
 * @version 2016-12-30
 */
public class MapUtil {

	/**
	 * 功能：将键值对转换成Map<br/>
	 *
	 * @author twfx
	 * @version 2016-4-15 上午09:31:26 <br/>
	 */
	public static <K, V> Map<K, V> toMap(K key, V value) {
		Map<K, V> map = new HashMap<K, V>();
		map.put(key, value);
		return map;
	}
}
