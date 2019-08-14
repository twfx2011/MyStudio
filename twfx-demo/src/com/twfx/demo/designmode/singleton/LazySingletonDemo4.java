/**
 * 文件名：@LazySingletonDemo4.java <br/>
 * 包名：com.twfx.designmode.singleton <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.designmode.singleton;

/**
 * 类名：LazySingletonDemo4 <br />
 *
 * 功能：懒汉式单例:指全局的单例实例在第一次被使用时构建。<br />
 * 实现：静态内部类：IoDH，initialization-on-demand holder
 * 说明：
 * 这个模式综合使用了Java的静态内部类和多线程缺省同步锁的知识，很巧妙地同时实现了延迟加载和线程安全。
 * 静态内部类相当于其外部类的static部分，它的对象不依赖于外部类对象，因此可以直接创建。静态内部类只有在第一次被使用的时候才会被转载。
 * @author twfx <br />
 *         创建时间：2019年7月8日 下午5:22:12 <br />
 * @version 2019年7月8日
 */
public class LazySingletonDemo4 {

	/**
	 * 构造方法
	 */
	private LazySingletonDemo4() {}

	/**
	 * 类名：SingletonHolder  <br />
	 *
	 * 功能：静态内部类
	 *
	 * @author twfx <br />
	 * 创建时间：2019年7月8日 下午5:24:10  <br />
	 * @version 2019年7月8日
	 */
	private static class SingletonHolder {
		private static final LazySingletonDemo4 INSTANCE = new LazySingletonDemo4();
	}

	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年7月8日 下午5:24:13 <br/>
	 */
	public static LazySingletonDemo4 getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
