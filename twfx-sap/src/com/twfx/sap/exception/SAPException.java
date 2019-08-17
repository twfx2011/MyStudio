/**
 * 文件名：@SAPException.java <br/>
 * 包名：com.twfx.sap.exception <br/>
 * 项目名：twfx-sap <br/>
 * @author twfx <br/>
 */
package com.twfx.sap.exception;

/**
 * 类名：SAPException <br />
 *
 * 功能：SAP运行时异常
 *
 * @author twfx <br />
 *         创建时间：2019年8月16日 下午4:43:09 <br />
 * @version 2019年8月16日
 */
public class SAPException extends RuntimeException {

	private static final long serialVersionUID = 6582089328270486438L;

	/**
	 * 构造方法
	 */
	public SAPException(String message) {
		super(message);
	}

	/**
	 * 构造方法
	 */
	public SAPException(String message, Throwable cause) {
		super(message, cause);
	}
}
