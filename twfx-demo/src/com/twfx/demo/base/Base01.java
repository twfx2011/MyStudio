/**
 * 文件名：@Base01.java <br/>
 * 包名：com.twfx.demo.base <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.base;

/**
 * 类名：Base01  <br />
 *
 * 功能： 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一
	         对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 *  程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21.... 
 *  总结出规律：前两项之和就是第三项
 	所以：第n个月的兔子数目为：f(n)=f(n-1)+f(n-2)
 *
 * @author twfx <br />
 * 创建时间：2019年9月17日 下午12:08:47  <br />
 * @version 2019年9月17日
 */
public class Base01 {

	/**
	 * 功能：获得每月兔子总数<br/>
	 * n:月份
	 * 用到了方法递归
	 * @author twfx
	 * @version 2019年9月17日 上午8:51:49 <br/>
	 */
	public static int f(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return f(n - 1) + f(n - 2);
	}
	
	public static void main(String[] args) {
		System.out.println(f(5));
	}
}
