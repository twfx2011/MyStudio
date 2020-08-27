/**
 * 文件名：@Test.java <br/>
 * 包名：com.twfx.demo.dbutils.test <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.dbutils.test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.twfx.demo.dbutils.model.User;
import com.twfx.demo.dbutils.utils.DBCPUtils;

/**
 * 类名：TestDBCPUtils <br />
 *
 * 功能：DBCPUtils工具测试类
 *
 * @author twfx <br />
 *         创建时间：2019年8月15日 下午4:50:30 <br />
 * @version 2019年8月15日
 */
public class TestDBCPUtils {

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
			QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
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
	 * 功能：批量添加用户<br/>
	 *
	 * @author twfx
	 * @version 2019年8月15日 下午5:08:38 <br/>
	 */
	@Test
	public void testBatchAddUser() {
		try {
			// 1.创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
			// 2.编写SQL语句
			String sql = "insert into user(userCode, userName, userPwd, state) values(?,?,?,?)";
			// 3.为占位符设置值
			Object[][] params = {{ "admin1", "管理员", "123456", 1 }, { "admin2", "管理员", "123456", 1 }};
			// 4.执行添加操作
			int[] rows = qr.batch(sql, params);
			System.out.println(Arrays.toString(rows));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /**
     * 功能：根据id修改用户密码<br/>
     *
     * @author twfx
     * @version 2019年8月15日 下午5:10:54 <br/>
     */
    @Test
    public void testUpdateUserById() {
        try {
            // 1.创建核心类QueryRunner
            QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
            // 2.编写SQL语句
            String sql = "update user set userPwd=? where id=?";
            // 3.为站位符设置值
            Object[] params = { "000000", 3 };
            // 4.执行添加操作
            int rows = qr.update(sql, params);
            if (rows > 0) {
                System.out.println("修改成功!");
            } else {
                System.out.println("修改失败!");
            }
        } catch (SQLException e) {
        	// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * 功能：根据id删除用户信息<br/>
     *
     * @author twfx
     * @version 2019年8月15日 下午5:14:54 <br/>
     */
    @Test
    public void testDeleteUserById() {
        try {
            // 1.创建核心类QueryRunner
            QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
            // 2.编写SQL语句
            String sql = "delete from user where id=?";
            // 3.为站位符设置值
            Object[] params = { 1 };
            // 4.执行添加操作
            int rows = qr.update(sql, params);
            if (rows > 0) {
                System.out.println("删除成功!");
            } else {
                System.out.println("删除失败!");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * 功能：查询所有用户信息<br/>
     *
     * @author twfx
     * @version 2019年8月15日 下午5:23:25 <br/>
     */
    @Test
    public void testQueryAll() {
        try {
            // 1.获取核心类queryRunner
            QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
            // 2.编写sql语句
            String sql = "select * from user";
            // 3.执行查询操作
            List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
            // 4.对结果集集合进行遍历
            for (User user : users) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /*
     * 根据id查询用户方法
     */
    @Test
    public void testQueryUserById() {
        try {
            // 1.获取核心类queryRunner
            QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
            // 2.编写sql语句
            String sql = "select * from user where id=?";
            //3.为占位符设置值
            Object[] params = { 3 };
            // 4.执行查询操作
            User user = qr.query(sql, new BeanHandler<User>(User.class), params);
            System.out.println(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /*
     * 根据所有用户的总个数
     */
    @Test
    public void testQueryCount() {
        try {
            // 1.获取核心类queryRunner
            QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
            // 2.编写sql语句
            String sql = "select count(*) from user";
            // 4.执行查询操作
            Long count = qr.query(sql, new ScalarHandler<Long>());
            System.out.println(count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 功能：查询所有用户信息，查询结果转换成Map<br/>
     *
     * @author twfx
     * @version 2019年8月15日 下午5:26:17 <br/>
     */
    @Test
    public void testQueryMap() {
        try {
            // 1.获取核心类queryRunner
            QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
            // 2.编写sql语句
            String sql = "select * from user";
            // 3.执行查询操作
            List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
            // 4.对结果集集合进行遍历
            for (Map<String, Object> map : list) {
                System.out.println(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 功能：查询用户的用户名称列<br/>
     *
     * @author twfx
     * @version 2019年8月15日 下午5:28:36 <br/>
     */
    @Test
    public void testQueryUserName() {
        try {
            // 1.获取核心类queryRunner
            QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
            // 2.编写sql语句
            String sql = "select * from user";
            // 3.执行查询操作
            List<String> list = qr.query(sql, new ColumnListHandler<String>("userName"));
            // 4.对结果集集合进行遍历
            for (String userName : list) {
                System.out.println(userName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
