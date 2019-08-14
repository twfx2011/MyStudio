/**
 * 文件名：@LazySingletonDemo2.java <br/>
 * 包名：com.twfx.designmode.singleton <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.designmode.singleton;

/**
 * 类名：LazySingletonDemo2  <br />
 *
 * 功能：懒汉式单例:指全局的单例实例在第一次被使用时构建。 <br />
 * 实现：synchronized（Lazy-loaded，线程安全，但不高效）
 * 说明：
 * 为了解决LazySingletonDemo1的问题，最简单的方法是将整个 getInstance() 方法设为同步（synchronized）。
 * 虽然做到了线程安全、延迟加载，但是它并不高效。因为在任何时候只能有一个线程调用 getInstance() 方法。
 * 但是synchronized操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。
 * 这种模式导致即使在单例创建完成后，每次依然只有一个线程可以访问getInstance（）方法，会导致潜在的性能问题。这就引出了双重检验锁。
 * @author twfx <br />
 * 创建时间：2019年7月8日 下午5:10:10  <br />
 * @version 2019年7月8日
 */
public class LazySingletonDemo2 {


	private static LazySingletonDemo2 instance;

	/**
	 * 构造方法
	 */
	private LazySingletonDemo2() {}
	
	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年7月8日 下午5:07:57 <br/>
	 */
	public static synchronized LazySingletonDemo2 getInstance() {
		if (instance == null) {
			instance = new LazySingletonDemo2();
		}
		return instance;
	}

}
