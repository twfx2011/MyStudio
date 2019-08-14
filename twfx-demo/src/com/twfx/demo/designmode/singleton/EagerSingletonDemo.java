/**
 * 文件名：@EagerSingleton.java <br/>
 * 包名：com.twfx.designmode.singleton <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.designmode.singleton;

/**
 * 类名：EagerSingleton  <br />
 *
 * 功能：饿汉式单例:指全局的单例实例在类装载时构建。<br />
 * 实现：static final field（非Lazy-loaded）
 * 说明：
 * 这种方法非常简单，因为单例的实例被声明成 static final，在第一次加载类到内存中时就会初始化，所以创建实例对象是线程安全的（由JVM实现保证）。
 * 它不是一种懒加载模式，instance会在加载类后一开始就被初始化，即使客户端没有调用 getInstance()方法。
 * 这会导致一些使用限制：譬如 Singleton 实例的创建是依赖参数或者配置文件的，在 getInstance() 之前必须调用某个方法设置参数给它，那样这种单例写法就无法使用了。
 * @author twfx <br />
 * 创建时间：2019年7月8日 下午4:13:43  <br />
 * @version 2019年7月8日
 */
public class EagerSingletonDemo {

	private static final EagerSingletonDemo INSTANCE = new EagerSingletonDemo();
	 
    /**
     * 构造方法
     */
    private EagerSingletonDemo() {}
 
    /**
     * 功能：<br/>
     *
     * @author twfx
     * @version 2019年7月8日 下午4:18:49 <br/>
     */
    public static EagerSingletonDemo getInstance() {
        return INSTANCE;
    }

}
