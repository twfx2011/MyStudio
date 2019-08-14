/**
 * 文件名：@LazySingletonDemo1.java <br/>
 * 包名：com.twfx.designmode.singleton <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.designmode.singleton;

/**
 * 类名：LazySingletonDemo1 <br />
 *
 * 功能：懒汉式单例:指全局的单例实例在第一次被使用时构建。 <br />
 * 实现：（Lazy-loaded，但线程不安全）
 * 说明：
 * 当被问到要实现一个单例模式时，很多人的第一反应是写出如下的代码，包括教科书上也是这样教我们的。
 * 这段代码简单明了，而且使用了延迟加载模式，但是线程不安全。多线程环境下调用 getInstance() 方法，可能会发生多个线程进入if语句的程序代码块。
 * 
 * @author twfx <br />
 *         创建时间：2019年7月8日 下午5:06:13 <br />
 * @version 2019年7月8日
 */
public class LazySingletonDemo1 {

	private static LazySingletonDemo1 instance;

	/**
	 * 构造方法
	 */
	private LazySingletonDemo1() {}
	
	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年7月8日 下午5:07:57 <br/>
	 */
	public static LazySingletonDemo1 getInstance() {
		if (instance == null) {
			instance = new LazySingletonDemo1();
		}
		return instance;
	}
}
