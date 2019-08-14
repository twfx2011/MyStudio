/**
 * 文件名：@ExecuteOrderParentDemo.java <br/>
 * 包名：com.twfx.demo <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.executeorder;

/**
 * 类名：ExecuteOrderParentDemo  <br />
 *
 * 功能：执行顺序父类
 *
 * @author twfx <br />
 * 创建时间：2019年7月8日 下午5:48:13  <br />
 * @version 2019年7月8日
 */
public class ExecuteOrderParentDemo {

	static int num = 4; // 父类静态变量

	static {
		System.out.println("父类静态代码块");
	}

	int a = 5; // 父类实例变量

	{
		num += 3;
		System.out.println("父类实例代码块1");
	}

	{
		System.out.println("父类实例代码块2");
	}

	/**
	 * 构造方法
	 */
	public ExecuteOrderParentDemo() {
		System.out.println("父类构造函数");
	}

	static void run() {
		System.out.println("父类静态方法");
	}
}
