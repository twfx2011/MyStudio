/**
 * 文件名：@Person.java <br/>
 * 包名：com.twfx.demo.enums <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.enums;

/**
 * 类名：Person  <br />
 *
 * 功能：人类-性别枚举采用Hibernate注解配置示例
 *
 * @author twfx <br />
 * 创建时间：2019年8月14日 下午4:33:08  <br />
 * @version 2019年8月14日
 */
public class Person {

	/** 姓名 */
	private String name;
	/** 性别 */
	private Gender gender;
	/** 年龄 */
	private Integer age;
	
	/**
	 * 获得 name值
	 */
	public String getName() {
		return name;
	}
	/**
	 * 将name设置为参数name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获得 gender值
	 * 
	 * Hibernate 枚举类型注解方式
	 * value = EnumType.ORDINAL 采用枚举的下标与数据库进行交互,用【数值类型】存储，从0开始，比如性别-男下标值是0，性别-女的下标值是1
	 * value = EnumType.STRING 采用枚举名称与数据库进行交互，数据库用【varchar字符串类型】存储，比如性别-男则是MALE,性别-女则是FEMALE
	 * 这里需要注意是value = EnumType.STRING是存储的是枚举名字值，而不是枚举类型定义后面的text文本值
	 */
	//@Enumerated(value = EnumType.STRING)
	public Gender getGender() {
		return gender;
	}
	/**
	 * 将gender设置为参数gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	/**
	 * 获得 age值
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 将age设置为参数age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
