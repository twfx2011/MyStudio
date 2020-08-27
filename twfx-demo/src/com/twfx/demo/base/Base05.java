/**
 * 文件名：@Base05.java <br/>
 * 包名：com.twfx.demo.base <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.base;

import java.util.Scanner;

/**
 * 类名：Base05  <br />
 *
 * 功能：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。 
 * 分析：(a>b)?a:b这是条件运算符的基本例子。
 *
 * @author twfx <br />
 * 创建时间：2019年9月17日 下午12:10:12  <br />
 * @version 2019年9月17日
 */
public class Base05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("请输入学生成绩:");
        double a = scanner.nextDouble();
        scanner.close();
        String grade = (a >= 90) ? "A" : (a >= 60 && a < 90) ? "B" : "C";
        System.out.println(grade);
	}
}
