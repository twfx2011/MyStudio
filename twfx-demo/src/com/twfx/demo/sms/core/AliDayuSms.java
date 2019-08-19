/**
 * 文件名：@AliyunSms.java <br/>
 * 包名：com.zhongpin.esb.datatrans.accept.http.special.aliyunsms.util <br/>
 * 项目名：esb-dataTrans <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.sms.core;

import java.util.HashMap;
import java.util.Map;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 类名：AliyunSms <br />
 *
 * 功能：阿里大鱼短信接口工具类
 *
 * @author twfx <br />
 *         创建时间：2019年3月13日 上午11:49:04 <br />
 * @version 2019年3月13日
 */
public class AliDayuSms {

	// 短信API产品名称（短信产品名固定，无需修改）
	static final String product = "Dysmsapi";
	// 短信API产品域名（接口地址固定，无需修改）
	static final String domain = "dysmsapi.aliyuncs.com";
	// 短信API访问key
	static final String accessKeyId = "yourAccessKeyId";
	// 短信API访问密钥
	static final String accessKeySecret = "yourAccessKeySecret";
	// 短信签名
	static final String signName = "yourSignName";

	/**
	 * 功能：发送短信<br/>
	 * 
	 * @param 1、phoneNumbers:
	 *            手机号 2、templateCode：阿里云的短信模板CODE
	 *            3、param：阿里云的短信模板中变量设置的值，param中的key对应短信模板的变量名
	 * @author twfx
	 * @version 2019年3月13日 下午5:49:55 <br/>
	 */
	public static Map<String, Object> send(String phoneNumbers, String templateCode, SmsCallback callback) {

		// 可自助调整超时时间
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");

		try {
			// 初始化acsClient,暂不支持region化
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
			IAcsClient acsClient = new DefaultAcsClient(profile);
			// 组装请求对象-具体描述见控制台-文档部分内容
			SendSmsRequest request = new SendSmsRequest();
			// 必填:待发送手机号
			request.setPhoneNumbers(phoneNumbers);
			// 必填:短信签名-可在短信控制台中找到
			request.setSignName(signName);
			// 必填:短信模板-可在短信控制台中找到
			request.setTemplateCode(templateCode);
			// 短信参数处理
			callback.templateParamHandle(request);

			SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
			
			Map<String, Object> result = new HashMap<>();
			if (sendSmsResponse != null && sendSmsResponse.getCode().equals("OK")) {
				result.put("result", true);
				return result;
			}

			result.put("result", false);
			result.put("errMsg", sendSmsResponse.getMessage());
			return result;
		}catch (ClientException e) {
			throw new RuntimeException("阿里大鱼短信发送出现异常：", e);
		}
	}

}
