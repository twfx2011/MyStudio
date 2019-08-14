/**
 * 文件名：@ExecuteOrderSubDemo.java <br/>
 * 包名：com.twfx.demo <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.executeorder;

/**
 * 类名：ExecuteOrderSubDemo  <br />
 *
 * 功能：执行顺序子类
 * 说明：
 * Java静态块、静态遍历、实例块、实例变量、构造方法执行顺序示例
 * 如果类还没有被加载： 
	1、先执行父类的静态代码块和静态变量初始化，并且静态代码块和静态变量的执行顺序只跟代码中出现的顺序有关。 
	2、执行子类的静态代码块和静态变量初始化。 
	3、执行父类的实例变量和实例代码块初始化，执行顺序也跟代码中出现的顺序有关。 
	4、执行父类的构造函数 
	5、执行子类的实例变量和实例代码块初始化，执行顺序也跟代码中出现的顺序有关。
	6、执行子类的构造函数 
	如果类已经被加载： 
	则静态代码块和静态变量就不用重复执行，再创建类对象时，只执行与实例相关的变量初始化和构造方法。
 *
 * @author twfx <br />
 * 创建时间：2019年7月8日 下午5:42:52  <br />
 * @version 2019年7月8日
 */
public class ExecuteOrderSubDemo extends ExecuteOrderParentDemo {

	static int num = 4; // 子类静态变量

	static {
		System.out.println("子类静态代码块");
	}

	int a = 5; // 子类实例变量

	{
		num += 3;
		System.out.println("子类实例代码块1");
	}

	{
		System.out.println("子类实例代码块2");
	}

	/**
	 * 构造方法
	 */
	public ExecuteOrderSubDemo() {
		System.out.println("子类构造函数");
	}

	static void run() {
		System.out.println("子类静态方法");
	}

	public static void main(String[] args) {
		
		new ExecuteOrderSubDemo();
	}

}
