/**
 * 文件名：@TestLog.java <br/>
 * 包名：com.twfx.demo.logs <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.logs;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类名：TestLog  <br />
 *
 * 功能：
 *
 * @author twfx <br />
 * 创建时间：2019年8月19日 上午10:50:34  <br />
 * @version 2019年8月19日
 */
public class TestLog {

	private static final Logger logger = LoggerFactory.getLogger(TestLog.class);
	
	@Test
	public void test() {
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
	}
}

