/**
 * 文件名：@PrimeFactor.java <br/>
 * 包名：com.twfx.demo.algorithm <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.algorithm;

import java.util.Scanner;

/**
 * 类名：PrimeFactor <br />
 *
 * 功能：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
 * (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
 * (2)如果n<>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数n,重复执行第一步。
 * (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
 * 
 * @author twfx <br />
 *         创建时间：2019年9月17日 上午10:56:44 <br />
 * @version 2019年9月17日
 */
public class PrimeFactor {

	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年9月17日 上午11:31:33 <br/>
	 */
	public static void f(int n, int k) {
		if (k == n) {
			System.out.print(n);
		}
		while (k != n) {
			if (n > k && n % k == 0) {
				System.out.print(k + "*");
				n = n / k;
				f(n, k);
				break;
			}else if (n > k && n % k != 0) {
				k++;
				f(n, k);
				break;
			}
		}
	}

	public static void main(String[] args) {
		System.out.print("请输入一个大于2的正整数：");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		System.out.print(n + "=");
		f(n, 2);

	}

}
