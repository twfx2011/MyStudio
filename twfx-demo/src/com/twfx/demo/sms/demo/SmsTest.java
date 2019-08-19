/**
 * 文件名：@SmsTest.java <br/>
 * 包名：com.twfx.demo.sms.demo <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.sms.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.exceptions.ClientException;
import com.twfx.demo.sms.core.AliDayuSms;
import com.twfx.demo.sms.core.SmsCallback;

/**
 * 类名：SmsTest  <br />
 *
 * 功能：短信发送测试
 *
 * @author twfx <br />
 * 创建时间：2019年8月17日 下午4:27:07  <br />
 * @version 2019年8月17日
 */
public class SmsTest {

	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年8月17日 下午4:27:23 <br/>
	 * @throws ClientException 
	 */
	@Test
	public void testSend() {
		
		final Map<String, String> params = new HashMap<>();
		Map<String, Object> map = AliDayuSms.send("xxxxx", "xxxxxx", new SmsCallback() {
			@Override
			public void templateParamHandle(SendSmsRequest request) {
				request.setTemplateParam("{\"code\":\""+ params.get("code") +"\"}");
			}
		});
		System.out.println(map);
	}
}
