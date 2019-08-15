/**
 * 文件名：@Users.java <br/>
 * 包名：com.twfx.demo.dbutils.model <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.dbutils.model;

/**
 * 类名：Users  <br />
 *
 * 功能：
 *
 * @author twfx <br />
 * 创建时间：2019年8月15日 下午4:35:45  <br />
 * @version 2019年8月15日
 */
public class User {

	/** 编号，数据库自增 */
	private Integer id;
	/** 用户账号 */
	private String userCode;
	/** 用户名称 */
	private String userName;
	/** 用户密码 */
	private String userPwd;
	/** 状态：0-停用，1-启用 */
	private Integer state;

	/**
	 * 获得 id值
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 将id设置为参数id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获得 userCode值
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * 将userCode设置为参数userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * 获得 userName值
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 将userName设置为参数userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获得 userPwd值
	 */
	public String getUserPwd() {
		return userPwd;
	}

	/**
	 * 将userPwd设置为参数userPwd
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	/**
	 * 获得 state值
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * 将state设置为参数state
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * 功能: <br/>
	 * 
	 * 重写：twfx <br/>
	 * 
	 * @version ：2019年8月15日 下午5:25:00<br/>
	 * 
	 * @return <br/>
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", userCode=" + userCode + ", userName=" + userName + ", userPwd=" + userPwd + ", state=" + state + "]";
	}
	
}
