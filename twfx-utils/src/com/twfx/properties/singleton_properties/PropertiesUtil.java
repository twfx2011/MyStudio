/**
 * 文件名：@PropertiesUtil1.java <br/>
 * 包名：com.twfx.properties <br/>
 * 项目名：twfx-utils <br/>
 * @author twfx <br/>
 */
package com.twfx.properties.singleton_properties;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 类名：PropertiesUtil <br />
 *
 * 功能：通过Properties读入属性文件：单例模式
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
	 * 创建时间：2019年8月13日 下午6:11:24  <br />
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
	 * @version 2019年8月13日 下午6:11:18 <br/>
	 */
	public static final PropertiesUtil getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * 功能：通过Properties方式读取属性文件<br/>
	 *
	 * @author twfx
	 * @version 2019年8月13日 下午6:01:36 <br/>
	 */
	private void readProperties() {
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("test.properties");
		Properties props = new Properties();
		try {
			props.load(in);
			Enumeration<?> keys = props.propertyNames();
			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				propMap.put(key, new String(props.getProperty(key).getBytes("ISO-8859-1"), "UTF-8"));
			}
		}catch (Exception e) {
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
