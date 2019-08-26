/**
 * 文件名：@StockInBill.java <br/>
 * 包名：com.twfx.demo.model <br/>
 * 项目名：twfx-print <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.model;

import java.util.List;

/**
 * 类名：StockInBill  <br />
 *
 * 功能：入库单
 *
 * @author twfx <br />
 * 创建时间：2019年8月21日 上午8:50:12  <br />
 * @version 2019年8月21日
 */
public class InStockBill {

	/** 入库单号 */
	private String id;
	/** 入库日期 */
	private String inStockDate;
	/** 入库仓库 */
	private String wareHouse;
	/** 供货单位 */
	private String supplyCompany;
	/** 备注 */
	private String remark;
	
	private List<InStockDetail> details;
	/**
	 * 获得 id值
	 */
	public String getId() {
		return id;
	}
	/**
	 * 将id设置为参数id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获得 inStockDate值
	 */
	public String getInStockDate() {
		return inStockDate;
	}
	/**
	 * 将inStockDate设置为参数inStockDate
	 */
	public void setInStockDate(String inStockDate) {
		this.inStockDate = inStockDate;
	}
	/**
	 * 获得 wareHouse值
	 */
	public String getWareHouse() {
		return wareHouse;
	}
	/**
	 * 将wareHouse设置为参数wareHouse
	 */
	public void setWareHouse(String wareHouse) {
		this.wareHouse = wareHouse;
	}
	/**
	 * 获得 supplyCompany值
	 */
	public String getSupplyCompany() {
		return supplyCompany;
	}
	/**
	 * 将supplyCompany设置为参数supplyCompany
	 */
	public void setSupplyCompany(String supplyCompany) {
		this.supplyCompany = supplyCompany;
	}
	/**
	 * 获得 remark值
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 将remark设置为参数remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获得 details值
	 */
	public List<InStockDetail> getDetails() {
		return details;
	}
	/**
	 * 将details设置为参数details
	 */
	public void setDetails(List<InStockDetail> details) {
		this.details = details;
	}
	
}
