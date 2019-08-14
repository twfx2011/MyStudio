/**
 * 文件名：@Color.java <br/>
 * 包名：com.twfx.demo.enums; <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.enums;

/**
 * 类名：Color  <br />
 *
 * 功能：枚举类型定义方法三
 *
 * @author twfx <br />
 * 创建时间：2013-10-15 上午08:36:31  <br />
 * @version 2013-10-15
 */
public enum Color2 {

	GREEN("green"),
	RED("red");
	
	private String color;
	private Color2(String color) {
		this.color = color;
	}
	/**
	 * 获得 color值
	 */
	public String getColor() {
		return color;
	}
	/**
	 * 将color设置为参数color
	 */
	public void setColor(String color) {
		this.color = color;
	}
}
