/**
 * 文件名：@SAPManagerCallback.java <br/>
 * 包名：com.twfx.sap <br/>
 * 项目名：twfx-sap <br/>
 * @author twfx <br/>
 */
package com.twfx.sap.core;

import com.sap.conn.jco.JCoParameterList;

/**
 * 类名：SAPManagerCallback  <br />
 *
 * 功能：SAP回调接口
 *
 * @author twfx <br />
 * 创建时间：2019年8月16日 下午4:14:31  <br />
 * @version 2019年8月16日
 */
public interface SAPRfcCallback<T> {

	/**
	 * 功能：SAP函数调用前执行，主要用于设置SAP请求参数<br/>
	 * @param importParamList import接口参数
	 * @param tableParamList table接口参数
	 * 
	 * @author twfx
	 * @version 2019年8月16日 下午4:16:50 <br/>
	 */
	public boolean doBefore(JCoParameterList importParamList, JCoParameterList tableParamList) throws Exception;
	
	/**
	 * 功能：SAP函数调用后执行，用于获取SAP返回数据<br/>
	 * @param exportParamList export接口参数
	 * @param tableParamList table接口参数
	 * @author twfx
	 * @version 2019年8月16日 下午4:33:10 <br/>
	 */
	public T doAfter(JCoParameterList exportParamList, JCoParameterList tableParamList) throws Exception;
}
