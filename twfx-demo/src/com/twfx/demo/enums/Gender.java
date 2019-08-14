/**
 * 文件名：@Gender.java <br/>
 * 包名：com.twfx.demo.enums <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.enums;

/**
 * 类名：Gender  <br />
 *
 * 功能：性别
 *
 * @author twfx <br />
 * 创建时间：2019年8月14日 下午4:27:54  <br />
 * @version 2019年8月14日
 */
public enum Gender {

	MALE("男"), // 男
	FEMALE("女"); // 女
	
	private String text;
	
	/**
	 * 构造方法
	 */
	private Gender(String text) {
		this.text = text;
	}

	/**
	 * 获得 text值
	 */
	public String getText() {
		return text;
	}

	/**
	 * 将text设置为参数text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
} 
