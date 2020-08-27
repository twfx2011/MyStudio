/**
 * 文件名：@Narcissus.java <br/>
 * 包名：com.twfx.demo.algorithm <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.algorithm;

/**
 * 类名：Narcissus <br />
 *
 * 功能：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如：
 * 153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。 程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
 * 
 * @author twfx <br />
 *         创建时间：2019年9月17日 上午9:47:49 <br />
 * @version 2019年9月17日
 */
public class Narcissus {

	public static void main(String[] args) {
		for (int i = 100; i <= 999; i++) {
			int a = i / 100; // 百位数
			int b = (i % 100) / 10; // 十位数
			int c = i % 10; // 个位数

			if (a*a*a + b*b*b + c*c*c == i) {
				System.out.println("水仙花数：" + i);
			}
		}
	}
}
