/**
 * 文件名：@TestC3P0Utils.java <br/>
 * 包名：com.twfx.demo.dbutils.test <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.dbutils.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.twfx.demo.dbutils.utils.C3P0Utils;
import com.twfx.demo.dbutils.utils.DBCPUtils;

/**
 * 类名：TestC3P0Utils  <br />
 *
 * 功能：C3P0Utils工具测试类
 *
 * @author twfx <br />
 * 创建时间：2019年8月15日 下午6:01:34  <br />
 * @version 2019年8月15日
 */
public class TestC3P0Utils {

	/**
	 * 功能：添加用户<br/>
	 *
	 * @author twfx
	 * @version 2019年8月15日 下午5:08:38 <br/>
	 */
	@Test
	public void testAddUser() {
		try {
			// 1.创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 2.编写SQL语句
			String sql = "insert into user(userCode, userName, userPwd, state) values(?,?,?,?)";
			// 3.为占位符设置值
			Object[] params = { "admin", "管理员", "123456", 1 };
			// 4.执行添加操作
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("添加成功!");
			}else {
				System.out.println("添加失败!");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 *  剩余其他方法同TestDBCPUtils一样，只是QueryRunner是C3P0Utils.getDataSource(),在此不再一一列举
	 */
}
