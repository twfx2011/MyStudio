/**
 * 文件名：@Base02.java <br/>
 * 包名：com.twfx.demo.base <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.base;

/**
 * 类名：Base02  <br />
 *
 * 功能：判断101-200之间有多少个素数，并输出所有素数。
 * 程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，反之是素数。 
 *
 * @author twfx <br />
 * 创建时间：2019年9月17日 下午12:09:43  <br />
 * @version 2019年9月17日
 */
public class Base02 {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 101; i < 200; i ++) {
			boolean flag = false;
			for (int j = 2; j <= Math.sqrt(i); j ++) {
				if (i % j == 0) {
					flag = false;
					break; // 存在一个余数为0，说明不是素数，直接退出
				}else {
					flag = true;
				}
			}
			if (flag) {
				count ++;
				System.out.println(i);
			}
		}
		System.out.println("\n素数个数：" + count);
		
	}
}
