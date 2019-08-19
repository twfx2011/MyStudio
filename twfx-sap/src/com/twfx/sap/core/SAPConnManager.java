/**
 * 文件名：@SAPConn.java <br/>
 * 包名：com.twfx.sap <br/>
 * 项目名：twfx-sap <br/>
 * @author twfx <br/>
 */
package com.twfx.sap.core;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.twfx.sap.exception.SAPRuntimeException;

/**
 * 类名：SAPConn <br />
 *
 * 功能：SAP连接配置
 *
 * @author twfx <br />
 *         创建时间：2019年8月16日 下午3:58:58 <br />
 * @version 2019年8月16日
 */
public class SAPConnManager {

	/** 日志记录器 */
	private static final Logger logger = LoggerFactory.getLogger(SAPConnManager.class);
	
	/** ABAP管道名称 */
	private static final String ABAP_AS_POOLED = "ABAP_AS_WITH_POOL";

	/** 属性文件key定义 */
	private static final String KEY_CLIENT_COMMENTS = "SAP.Client_Comments";
	private static final String KEY_CLIENT_HOST = "SAP.Client_Host";
	private static final String KEY_CLIENT_SYSTEMNO = "SAP.Client_SystemNo";
	private static final String KEY_CLIENT_CLIENT = "SAP.Client_Client";
	private static final String KEY_CLIENT_USER = "SAP.Client_User";
	private static final String KEY_CLIENT_PASSWORD = "SAP.Client_Password";
	private static final String KEY_CLIENT_LANG = "SAP.Client_Lang";
	private static final String KEY_DESTINATION_POOLCAPACITY = "SAP.Destination_PoolCapacity";
	private static final String KEY_DESTINATION_PEAKLIMIT = "SAP.Destination_PeakLimit";

	/** SAP属性文件配置 */
	private static final ResourceBundle resource = ResourceBundle.getBundle("SAP");

	/**
	 * 初始化SAP连接配置
	 */
	static {
		Properties connectProperties = new Properties();
		connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, resource.getString(KEY_CLIENT_HOST));// 服务器
		connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, resource.getString(KEY_CLIENT_SYSTEMNO)); // 系统编号
		connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, resource.getString(KEY_CLIENT_CLIENT));// SAP集团
		connectProperties.setProperty(DestinationDataProvider.JCO_USER, resource.getString(KEY_CLIENT_USER)); // SAP用户名
		connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, resource.getString(KEY_CLIENT_PASSWORD)); // 密码
		connectProperties.setProperty(DestinationDataProvider.JCO_LANG, resource.getString(KEY_CLIENT_LANG)); // 登录语言
		connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, resource.getString(KEY_DESTINATION_POOLCAPACITY));// 最大连接数
		connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, resource.getString(KEY_DESTINATION_PEAKLIMIT)); // 最大连接线程

		createDataFile(ABAP_AS_POOLED, "jcoDestination", connectProperties);
	}

	/**
	 * 创建SAP接口属性文件。
	 * @param name ABAP管道名称
	 * @param suffix 属性文件后缀
	 * @param properties 属性文件内容
	 */
	private static void createDataFile(String name, String suffix, Properties properties) {
		File cfg = new File(name + "." + suffix);
		if (cfg.exists()) {
			cfg.deleteOnExit();
		}
		try {
			FileOutputStream fos = new FileOutputStream(cfg, false);
			properties.store(fos, resource.getString(KEY_CLIENT_COMMENTS));
			fos.close();
		}catch (Exception e) {
			logger.error("创建【{}】SAP接口配置文件出现异常：", cfg.getName(), e);
		}
	}

	/**
	 * 功能：获得SAP连接<br/>
	 * 
	 * @return SAP连接对象
	 */
	public static JCoDestination connect() {
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(ABAP_AS_POOLED);
			return destination;
		}catch (JCoException e) {
			throw new SAPRuntimeException("获取SAP连接出现异常：", e);
		}
	}
	
	/**
	 * 功能：获得SAP函数<br/>
	 *
	 * @author twfx
	 * @version 2019年8月17日 上午9:29:31 <br/>
	 */
	public static JCoFunction getFunction(JCoDestination destination, String funcName) {
		try {
			return destination.getRepository().getFunction(funcName);
		}catch (JCoException e) {
			throw new SAPRuntimeException("获取SAP【" + funcName + "】函数时出现异常：", e);
		}
	}
}
