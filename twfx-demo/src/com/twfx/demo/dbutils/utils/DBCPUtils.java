/**
 * 文件名：@JDBCUtils.java <br/>
 * 包名：com.twfx.demo.dbutils.utils <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.dbutils.utils;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 类名：JDBCUtils  <br />
 *
 * 功能：DBCP连接池工具类
 * DBCP也是一个开源的连接池，是Apache上的一个java连接池项目，在企业开发中也比较常见，tomcat内置的连接池。
 * 需要导入commons-dbcp-1.4.jar和commons-pool-1.5.6.jar包
 *
 * @author twfx <br />
 * 创建时间：2019年8月15日 下午4:23:15  <br />
 * @version 2019年8月15日
 */
public class DBCPUtils {

	/** 数据源 */
	private static DataSource dataSource;
	
	/**
	 * 初始化数据库连接池
	 */
	static {
		try {
            InputStream is = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcp-db.properties");
            //2.加载输入流
            Properties prop = new Properties();
            prop.load(is);
            //3.创建数据源
            dataSource = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	/**
	 * 获得 dataSource值
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	
}
