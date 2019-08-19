/**
 * 文件名：@SmsCallback.java <br/>
 * 包名：com.twfx.demo.sms.core <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.sms.core;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;

/**
 * 类名：SmsCallback  <br />
 *
 * 功能：短信回调方法
 *
 * @author twfx <br />
 * 创建时间：2019年8月17日 下午4:10:04  <br />
 * @version 2019年8月17日
 */
public interface SmsCallback {

	/**
	 * 功能：模板参数处理<br/>
	 *
	 * @author twfx
	 * @version 2019年8月17日 下午4:11:23 <br/>
	 */
	public void templateParamHandle(SendSmsRequest request);
}
