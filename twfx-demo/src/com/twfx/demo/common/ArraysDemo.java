/**
 * 文件名：@ArraysDemo.java <br/>
 * 包名：com.twfx.demo.common <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.common;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 类名：ArraysDemo  <br />
 *
 * 功能：数组示例
 *
 * @author twfx <br />
 * 创建时间：2019年8月26日 下午2:57:30  <br />
 * @version 2019年8月26日
 */
public class ArraysDemo {

	String[] array = new String[]{"a","c","2","1","b"};
    Integer[] ints = new Integer[]{5,1,4,3,2};
	
	/**
	 * 功能：数组转换成list<br/>
	 *
	 * @author twfx
	 * @version 2019年8月26日 下午2:59:29 <br/>
	 */
	@Test
	public void asList() {
		List<String> lists = Arrays.asList(array);
	}
	
	@Test
	public void sort() {
		Arrays.sort(ints, 2, 5);
		for (int i = 0; i < ints.length; i++) {
			System.out.print(" " + ints[i]);
		}
	}
	
}
