/**
 * 文件名：@BaseDemo.java <br/>
 * 包名：com.twfx.demo.algorithm <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.algorithm;

import org.junit.Test;

/**
 * 类名：BaseDemo  <br />
 *
 * 功能：Java 50基础编程练习题
 *
 * @author twfx <br />
 * 创建时间：2019年9月17日 下午12:04:48  <br />
 * @version 2019年9月17日
 */
public class BaseDemo {

	/**
	 * 功能： 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一
	         对兔子，假如兔子都不死，问每个月的兔子总数为多少？
	 *  程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21.... 
	 *  总结出规律：前两项之和就是第三项
 		所以：第n个月的兔子数目为：f(n)=f(n-1)+f(n-2)
	 *
	 * @author twfx
	 * @version 2019年9月17日 下午12:06:57 <br/>
	 */
	@Test
	public void base01() {
		
	}
	
	public static int f(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return f(n - 1) + f(n - 2);
	}
}
