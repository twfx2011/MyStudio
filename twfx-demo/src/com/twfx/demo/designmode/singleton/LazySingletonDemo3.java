/**
 * 文件名：@LazySingletonDemo.java <br/>
 * 包名：com.twfx.designmode.singleton <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.designmode.singleton;

/**
 * 类名：LazySingletonDemo3 <br />
 *
 * 功能：懒汉式单例:指全局的单例实例在第一次被使用时构建。<br />
 * 实现：双重检验锁 + volatile（Lazyload，线程安全，但晦涩）
 *
 * 双重检验锁模式（double checked locking pattern），是一种使用同步块加锁的方法。程序员称其为双重检查锁，
 * 因为会有两次检查 instance == null，一次是在同步块外，一次是在同步块内。
 * 为什么在同步块内还要再检验一次？因为可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例对象了
 * @author twfx <br />
 *         创建时间：2019年7月8日 下午4:15:01 <br />
 * @version 2019年7月8日
 */
public class LazySingletonDemo3 {

	/** volatile：多个线程并发访问可见性 */
	private static volatile LazySingletonDemo3 instance;

	/**
	 * 构造方法
	 */
	private LazySingletonDemo3() {}

	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年7月8日 下午4:17:27 <br/>
	 */
	public static LazySingletonDemo3 getInstance() {
		if (instance == null) { // Single checked
			// 当实例为空时才进行加锁创建实例
			synchronized (LazySingletonDemo3.class) {
				if (instance == null) { // Double checked
					instance = new LazySingletonDemo3();
				}
			}
		}
		return instance;
	}

}
