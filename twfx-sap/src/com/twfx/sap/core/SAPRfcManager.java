/**
 * 文件名：@SAPManagerFactory.java <br/>
 * 包名：com.twfx.sap <br/>
 * 项目名：twfx-sap <br/>
 * @author twfx <br/>
 */
package com.twfx.sap.core;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.twfx.sap.exception.SAPException;

/**
 * 类名：SAPManagerFactory <br />
 *
 * 功能：SAPRFC调用类
 *
 * @author twfx <br />
 *         创建时间：2019年8月16日 下午4:12:52 <br />
 * @version 2019年8月16日
 */
public class SAPRfcManager {

	/**
	 * 功能：执行SAP函数，带参数带返回值<br/>
	 *
	 * @param funcName：SAP函数名称
	 * @param callback：调用SAP函数前、后需要做的操作
	 * 
	 * @author twfx
	 * @version 2019年8月16日 下午4:13:37 <br/>
	 */
	public static <T> T execute(String funcName, SAPRfcCallback<T> callback) {

		JCoDestination destination = SAPConnManager.connect();
		// 获取SAP函数
		JCoFunction function = SAPConnManager.getFunction(destination, funcName);

		try {
			// 调用SAP函数前执行
			if (!callback.doBefore(function.getImportParameterList(), function.getTableParameterList())) {
				return null;
			}
			// 执行SAP函数
			function.execute(destination);

			// 调用SAP函数后执行
			T t = callback.doAfter(function.getExportParameterList(), function.getTableParameterList());

			return t;
		}catch (Exception e) {
			throw new SAPException("SAP函数执行时出现错误:", e);
		}
	}
	
	/**
	 * 功能：执行SAP函数，无参数无返回值<br/>
	 *
	 * @author twfx
	 * @version 2019年8月17日 上午9:27:24 <br/>
	 */
	public static void execute(String funcName) {
		
		JCoDestination destination = SAPConnManager.connect();
		// 获取SAP函数
		JCoFunction function = SAPConnManager.getFunction(destination, funcName);
		
		// 执行SAP函数
		try {
			function.execute(destination);
		}catch (JCoException e) {
			throw new SAPException("SAP函数执行时出现错误:", e);
		}
	}
}
