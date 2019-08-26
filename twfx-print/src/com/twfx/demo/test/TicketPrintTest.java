/**
 * 文件名：@TicketPrintTest.java <br/>
 * 包名：com.twfx.demo.test <br/>
 * 项目名：twfx-print <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.twfx.demo.model.SalesFlow;
import com.twfx.print.utils.TicketPrintUtil;

/**
 * 类名：TicketPrintTest  <br />
 *
 * 功能：
 *
 * @author twfx <br />
 * 创建时间：2019年8月21日 上午11:23:28  <br />
 * @version 2019年8月21日
 */
public class TicketPrintTest {

	/**
	 * 功能：小票打印测试<br/>
	 *
	 * @author twfx
	 * @version 2019年8月19日 下午3:03:48 <br/>
	 */
	@Test
	public void testPrintUSB() {
		
		// 组装数据
		List<SalesFlow> list = new ArrayList<SalesFlow>();
		list.add(new SalesFlow("鲁花花生油1L", 1.000, 36.90));
		list.add(new SalesFlow("海天500ml珍酿生抽", 1.000, 5.50));
		list.add(new SalesFlow("青蛙牙刷", 1.000, 14.50));
		list.add(new SalesFlow("上海青", 0.672, 4.76));
		list.add(new SalesFlow("西红柿", 1.610, 2.36));
		
		TicketPrintUtil.printUSB(getPrintFile(list));
	}
	
	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年8月21日 上午11:44:52 <br/>
	 */
	private String getPrintFile(List<SalesFlow> list) {
		String fileName = System.getProperty("user.dir") + "\\" + System.currentTimeMillis() + ".txt";
		Writer writer = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(new File(fileName)), "GBK");
			writer.write("   xxx购物广场欢迎您       ");
			writer.write("\r\n");
			writer.write("单号：190818111644018917");
			writer.write("\r\n");
			writer.write("日期：2018-8-18 11:17:42");
			writer.write("\r\n");
			writer.write("收款机号：01    " + "收银员：1001");
			writer.write("\r\n");
			writer.write("-----------销------售-----------");
			writer.write("\r\n");
			writer.write("品名     单价     数量     金额");
			writer.write("\r\n");
			double sumMoney = 0.00;
			for (SalesFlow flow : list) {
				sumMoney += flow.getMoney();
				writer.write(flow.getGoodsName());
				writer.write("\r\n");
				writer.write("          "+ flow.getUnitPrice() + "     " + flow.getNum() + "     " + flow.getMoney());
				writer.write("\r\n");
			}
			writer.write("--------------------------------");
			writer.write("\r\n");
			writer.write("应付：" + sumMoney + "   实收：" + sumMoney);
			writer.write("\r\n");
			writer.write("件数：" + list.size());
			writer.write("\r\n");
			writer.write("打印人：");
			writer.write("\r\n");
			writer.write("打印时间：");
			writer.write("\r\n");
			writer.write("\r\n");
			writer.write("\r\n");
			writer.write("\r\n");
			writer.write("\r\n");
			writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileName;
	} 
}
