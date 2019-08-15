/**
 * 文件名：@C3P0Utils.java <br/>
 * 包名：com.twfx.demo.dbutils.utils <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.dbutils.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 类名：C3P0Utils <br />
 *
 * 功能：C3P0连接池工具类
 * 参考博客地址：https://www.cnblogs.com/zhaojiankai/p/7891521.html
 * C3P0开源免费的连接池。目前使用它的开源项目有：Spring、Hibernate等。
 * 使用第三方工具需要导入jar包，c3p0使用时可以添加配置文件c3p0-config.xml（或者c3p0.properties，大部分使用c3p0-config.xml），
 * 也可以不添加配置文件。它有两种使用方式，但是多数情况下都是用需要配置文件的那种方式。
 *
 * @author twfx <br />
 *         创建时间：2019年8月15日 下午5:42:32 <br />
 * @version 2019年8月15日
 */
public class C3P0Utils {

	/** c3p0连接池：加载默认配置 */
//	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	/** c3p0连接池：加载自定义的配置 */
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("myDataSource");

	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年8月15日 下午5:45:03 <br/>
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
}
