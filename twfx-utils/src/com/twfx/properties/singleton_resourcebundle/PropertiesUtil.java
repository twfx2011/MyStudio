/**
 * 文件名：@PropertiesUtil1.java <br/>
 * 包名：com.twfx.properties <br/>
 * 项目名：twfx-utils <br/>
 * @author twfx <br/>
 */
package com.twfx.properties.singleton_resourcebundle;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 类名：PropertiesUtil <br />
 *
 * 功能：通过ResourceBundle读取属性文件：单例模式
 *
 * @author twfx <br />
 *         创建时间：2019年8月13日 下午5:11:02 <br />
 * @version 2019年8月13日
 */
public class PropertiesUtil {

	/** 用于存放属性键值对 */
	private Map<String, String> propMap = new HashMap<>();

	/**
	 * 类名：SingletonHolder  <br />
	 *
	 * 功能：通过静态内部类实现单例模式
	 *
	 * @author twfx <br />
	 * 创建时间：2019年8月13日 下午6:12:25  <br />
	 * @version 2019年8月13日
	 */
	private static class SingletonHolder {
		private static final PropertiesUtil INSTANCE = new PropertiesUtil();
	}

	/**
	 * 构造方法
	 */
	private PropertiesUtil() {
		readProperties();
	}

	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年8月13日 下午6:12:31 <br/>
	 */
	public static final PropertiesUtil getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * 功能：读取属性文件<br/>
	 *
	 * @author twfx
	 * @version 2019年8月13日 下午6:00:48 <br/>
	 */
	private void readProperties() {
		ResourceBundle resource = ResourceBundle.getBundle("test");
		Enumeration<String> keys = resource.getKeys();
		try {
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				propMap.put(key, new String(resource.getString(key).getBytes("ISO-8859-1"), "UTF-8"));
			}
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 功能：根据指定的key获取属性值<br/>
	 *
	 * @author twfx
	 * @version 2019年8月13日 下午5:32:09 <br/>
	 */
	public String getProperty(String key) {
		return propMap.get(key);
	}

}
