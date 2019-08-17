/**
 * 文件名：@DemoTest.java <br/>
 * 包名：com.twfx.sap.demo <br/>
 * 项目名：twfx-sap <br/>
 * @author twfx <br/>
 */
package com.twfx.sap.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.twfx.sap.core.SAPRfcCallback;
import com.twfx.sap.core.SAPRfcManager;

/**
 * 类名：DemoTest  <br />
 *
 * 功能：Demo测试，如果此项目作为依赖包时，打jar包时请将此demo包忽略掉
 *
 * @author twfx <br />
 * 创建时间：2019年8月17日 下午3:10:21  <br />
 * @version 2019年8月17日
 */
public class DemoTest {

	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年8月17日 下午3:12:58 <br/>
	 */
	@Test
	public void testExecute() {
		
		Map<String, Object> map = SAPRfcManager.execute("ZSEND_INFO", new SAPRfcCallback<Map<String, Object>>() {
			/**
			 * 功能: 设置请求参数<br/>
			 * 
			 * 重写：twfx <br/>
			 * 
			 * @version ：2019年8月17日 上午9:51:49<br/>
			 * 
			 * @param importParamList
			 * @param tableParamList
			 * @return
			 * @throws Exception <br/>
			 * @see com.twfx.sap.core.SAPRfcCallback#doBefore(com.sap.conn.jco.JCoParameterList, com.sap.conn.jco.JCoParameterList)
			 */
			@Override
			public boolean doBefore(JCoParameterList importParamList, JCoParameterList tableParamList) throws Exception {
				importParamList.setValue("VBELN", "001");
				importParamList.setValue("DATATYPE", "DOWNDELIVERY");
				return true;
			}

			/**
			 * 功能: 返回函数执行结果<br/>
			 * 
			 * 重写：twfx <br/>
			 * 
			 * @version ：2019年8月17日 上午9:52:03<br/>
			 * 
			 * @param exportParamList
			 * @param tableParamList
			 * @return
			 * @throws Exception <br/>
			 * @see com.twfx.sap.core.SAPRfcCallback#doAfter(com.sap.conn.jco.JCoParameterList, com.sap.conn.jco.JCoParameterList)
			 */
			@Override
			public Map<String, Object> doAfter(JCoParameterList exportParamList, JCoParameterList tableParamList) throws Exception {
				 Map<String, Object> map = new HashMap<String, Object>();
					JCoTable table = tableParamList.getTable("T_DOWN_DELIVERY");
					JCoStructure structure = exportParamList.getStructure("E_DOWN_DELIVERY");
					map.put("orderType", structure.getString("LFART")); // 订单类型
					map.put("orderNo", structure.getString("VBELN")); // 交货单号
					map.put("createUser", structure.getString("ERNAM")); // 创建人
					map.put("orderDate", structure.getString("ERDAT")); // 创建日期/订单日期
					map.put("totalWeight", structure.getString("BTGEW")); // 总重量
					map.put("shipPoint", structure.getString("VSTEL")); // 装运点
					map.put("headText", structure.getString("LFTXT")); // 抬头文本
					map.put("customerId", structure.getString("KUNAG")); // 客户代码
					map.put("customerName", structure.getString("NAME1")); // 客户名称
					List<Map<String, String>> detaiList = new ArrayList<Map<String, String>>();
					int rows = table.getNumRows();
					Map<String, String> detailMap = null;
					for (int row = 0; row < rows; row++) {
						detailMap = new HashMap<String, String>();
						table.setRow(row);
						detailMap.put("orderNo", table.getString("VBELN"));// 交货单号
						detailMap.put("lineNo", table.getString("POSNR"));// 行号
						detailMap.put("weight", table.getString("LFIMG"));// 重量
						detailMap.put("unit", table.getString("VRKME"));// 单位
						detailMap.put("createUser", table.getString("ERNAM"));// 创建人
						detailMap.put("createDate", table.getString("ERDAT"));// 创建日期
						detailMap.put("factoryId", table.getString("WERKS"));// 工厂
						detailMap.put("materialId", table.getString("MATNR"));// 物料编号
						detailMap.put("materialName", table.getString("ARKTX"));// 物料描述
						detailMap.put("numerator", table.getString("UMVKZ"));//销售数量转换成SKU的分子(因子)
						detailMap.put("divisor", table.getString("UMVKN"));//销售数量转换为 SKU 的值（除数）
						detailMap.put("whiteBarNum", table.getString("KDMAT"));// 红白条数
						detailMap.put("materialGroup", table.getString("MATKL"));// 物料组
						detailMap.put("wareHouseId", table.getString("LGORT"));// 库存地点编号
						detailMap.put("remark", table.getString("LFTXT"));// 行项目文本
						detaiList.add(detailMap);
					}
					map.put("details", detaiList);
					return map;
			}
		});
        
		System.out.println(map);
	
	}
}
