/**
 * 文件名：@InStockDetail.java <br/>
 * 包名：com.twfx.demo.model <br/>
 * 项目名：twfx-print <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.model;

/**
 * 类名：InStockDetail  <br />
 *
 * 功能：入库单明细
 *
 * @author twfx <br />
 * 创建时间：2019年8月21日 上午8:54:56  <br />
 * @version 2019年8月21日
 */
public class InStockDetail {

	/** 编号 */
	private long id;
	/** 入库单号  */
	private String inStockBillId;
	/** 存货编号 */
	private String goodsId;
	/** 存货名称 */
	private String goodsName;
	/** 规格型号 */
	private String model;
	/** 数量 */
	private double num;
	/** 单价 */
	private double unitPrice;
	/** 金额 */
	private double money;
	/**
	 * 获得 id值
	 */
	public long getId() {
		return id;
	}
	/**
	 * 将id设置为参数id
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * 获得 inStockBillId值
	 */
	public String getInStockBillId() {
		return inStockBillId;
	}
	/**
	 * 将inStockBillId设置为参数inStockBillId
	 */
	public void setInStockBillId(String inStockBillId) {
		this.inStockBillId = inStockBillId;
	}
	/**
	 * 获得 goodsId值
	 */
	public String getGoodsId() {
		return goodsId;
	}
	/**
	 * 将goodsId设置为参数goodsId
	 */
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获得 goodsName值
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 将goodsName设置为参数goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获得 model值
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 将model设置为参数model
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * 获得 num值
	 */
	public double getNum() {
		return num;
	}
	/**
	 * 将num设置为参数num
	 */
	public void setNum(double num) {
		this.num = num;
	}
	/**
	 * 获得 unitPrice值
	 */
	public double getUnitPrice() {
		return unitPrice;
	}
	/**
	 * 将unitPrice设置为参数unitPrice
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * 获得 money值
	 */
	public double getMoney() {
		return money;
	}
	/**
	 * 将money设置为参数money
	 */
	public void setMoney(double money) {
		this.money = money;
	}
	
}
