package com.twfx.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类名：ThreadTool <br />
 *
 * 功能：线程池：采用静态内部类实现单例模式，实现线程池只生成一个实例
 *
 * @author twfx <br />
 *         创建时间：2017年7月14日 上午10:57:50 <br />
 * @version 2017年7月14日
 */
public class ThreadTool {

	private ExecutorService exce;

	private static class SingletonHolder {
		private static final ThreadTool INSTANCE = new ThreadTool();
	}

	private ThreadTool() {
		exce = Executors.newFixedThreadPool(5);
	}

	public static final ThreadTool getInstance() {
		return SingletonHolder.INSTANCE;
	}


	// 执行线程
	public static void execute(Runnable run) {
		getInstance().exce.execute(run);
	}

}
