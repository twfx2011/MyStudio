/**
 * 文件名：@SalesFlow.java <br/>
 * 包名：com.twfx.print.demo <br/>
 * 项目名：twfx-print <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 类名：SalesFlow  <br />
 *
 * 功能：销售流水
 *
 * @author twfx <br />
 * 创建时间：2019年8月19日 下午3:26:26  <br />
 * @version 2019年8月19日
 */
public class SalesFlow {

	/** 商品名称 */
	private String goodsName;
	/** 单价 */
	private double unitPrice;
	/** 数量 */
	private double num;
	/** 金额 */
	private double money;
	
	/**
	 * 构造方法
	 */
	public SalesFlow() {
	}
	
	
	public SalesFlow(String goodsName, double num, double unitPrice) {
		super();
		this.goodsName = goodsName;
		this.unitPrice = unitPrice;
		this.num = num;
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
	 * 获得 unitPrice值
	 */
	public double getUnitPrice() {
		return new BigDecimal(unitPrice).setScale(2, RoundingMode.UP).doubleValue();
	}
	/**
	 * 将unitPrice设置为参数unitPrice
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * 获得 num值
	 */
	public double getNum() {
		return new BigDecimal(num).setScale(3, RoundingMode.UP).doubleValue();
	}
	/**
	 * 将num设置为参数num
	 */
	public void setNum(double num) {
		this.num = num;
	}
	/**
	 * 获得 money值
	 */
	public double getMoney() {
		money = num * unitPrice;
		return new BigDecimal(money).setScale(2, RoundingMode.UP).doubleValue();
	}
	/**
	 * 将money设置为参数money
	 */
	public void setMoney(double money) {
		this.money = money;
	}
	
}
