/**
 * 文件名：@PrintTest.java <br/>
 * 包名：com.twfx.print.demo <br/>
 * 项目名：twfx-print <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.twfx.demo.model.InStockBill;
import com.twfx.demo.model.InStockDetail;
import com.twfx.excel.utils.ExcelUtil;
import com.twfx.print.utils.ExcelPrintUtil;

/**
 * 类名：PrintTest  <br />
 *
 * 功能：打印测试
 *
 * @author twfx <br />
 * 创建时间：2019年8月19日 下午3:02:34  <br />
 * @version 2019年8月19日
 */
public class ExcelPrintTest {

	/**
	 * 功能：测试Excel打印<br/>
	 *
	 * @author twfx
	 * @version 2019年8月19日 下午5:47:07 <br/>
	 */
	@Test
	public void testPrintExcel() {
		
		// 组装数据
		InStockBill bill = new InStockBill();
		bill.setId("00001866");
		bill.setInStockDate("2019-08-21");
		bill.setWareHouse("原料库");
		bill.setSupplyCompany("其他");
		bill.setRemark("哈哈哈");
		
		InStockDetail detail1 = new InStockDetail();
		detail1.setGoodsId("000001");
		detail1.setGoodsName("上海青");
		detail1.setModel("1*500g");
		detail1.setNum(10);
		detail1.setUnitPrice(4.76);
		detail1.setMoney(47.6);
		
		InStockDetail detail2 = new InStockDetail();
		detail2.setGoodsId("000002");
		detail2.setGoodsName("西红柿");
		detail2.setModel("1*500g");
		detail2.setNum(10);
		detail2.setUnitPrice(2.36);
		detail2.setMoney(23.6);
		bill.setDetails(Arrays.asList(detail1, detail2));
		
//		ExcelPrintUtil.print_jcom(getExcelFile(bill));
		
		ExcelPrintUtil.print_jacob(getExcelFile(bill));
	}
	
	
	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年8月19日 下午5:57:46 <br/>
	 */
	private String getExcelFile(InStockBill bill) {
		OutputStream os = null;
		InputStream ins = null;
		String filePath = System.getProperty("user.dir") + "\\" + System.currentTimeMillis() + ".xlsx";
		try {
			 os = new FileOutputStream(new File(filePath));
		     int bytesRead = 0;
		     byte[] buffer = new byte[8192];
		     ins = generateTemplate(bill);
		     while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
		        os.write(buffer, 0, bytesRead);
		     }
		 } catch (IOException e) {
			 e.printStackTrace();
		 }finally {
			try {
				if (null != os) {
					os.close();
				}
				if (null != ins) {
					ins.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
		return filePath;
	}
	
	/**
	 * 功能：获得单据头样式<br/>
	 *
	 * @author twfx
	 * @version 2019年8月21日 上午10:58:24 <br/>
	 */
	private XSSFCellStyle getHeaderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle cellStyle = workbook.createCellStyle(); // 创建excel样式
		cellStyle.setAlignment(HorizontalAlignment.CENTER); //设置居中
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		ExcelUtil.setFont(workbook, cellStyle, IndexedColors.BLACK.getIndex(), 14, "宋体", XSSFFont.BOLDWEIGHT_BOLD);
		return cellStyle;
	}
	
	/**
	 * 功能：普通文本样式_居中对齐<br/>
	 *
	 * @author 孟雪勤
	 * @version 2015年12月6日 下午3:24:51 <br/>
	 */
	private XSSFCellStyle getCellCenterStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		ExcelUtil.setFont(workbook, style, IndexedColors.BLACK.getIndex(), 10, "宋体", XSSFFont.BOLDWEIGHT_NORMAL);

		return style;
	}
	
	/**
	 * 功能：普通文本样式_右对齐<br/>
	 *
	 * @author 孟雪勤
	 * @version 2015年12月6日 下午3:24:51 <br/>
	 */
	private XSSFCellStyle getCellRightStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.RIGHT);
		style.setVerticalAlignment(VerticalAlignment.CENTER); //垂直居中对齐
		ExcelUtil.setFont(workbook, style, IndexedColors.BLACK.getIndex(), 10, "宋体", XSSFFont.BOLDWEIGHT_NORMAL);
		return style;
	}

	/**
	 * 功能：普通文本样式_左对齐<br/>
	 *
	 * @author 孟雪勤
	 * @version 2015年12月6日 下午3:24:51 <br/>
	 */
	private XSSFCellStyle getCellLeftStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.LEFT); //水平左对齐
		style.setVerticalAlignment(VerticalAlignment.CENTER); //垂直居中对齐
		ExcelUtil.setFont(workbook, style, IndexedColors.BLACK.getIndex(), 10, "宋体", XSSFFont.BOLDWEIGHT_NORMAL);
		return style;
	}
	
	/**
	 * 功能：生成Excel打印模板<br/>
	 * 
	 *
	 * @author twfx
	 * @version 2019年8月19日 下午5:51:10 <br/>
	 */
	private InputStream generateTemplate(InStockBill bill) {
		
		// 声明一个工作薄
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("采购入库单打印模板");
		sheet.setDefaultColumnWidth(5);
		// 打印起始位置设置
		sheet.setMargin(XSSFSheet.TopMargin, 0); // 上边距
		sheet.setMargin(XSSFSheet.BottomMargin, 0); // 上边距
		sheet.setMargin(XSSFSheet.LeftMargin, 0.3); // 左边距
		sheet.setMargin(XSSFSheet.RightMargin, 0.3); // 右边距
		
		// 第一行
		int rowIndex = 0;
		XSSFCellStyle headerStyle = getHeaderStyle(workbook);
		ExcelUtil.setMergeCellValue(sheet, headerStyle, rowIndex, 0, rowIndex, 13, "采购入库单");
		
		// 第二行
		rowIndex ++;
		XSSFCellStyle rightStyle = getCellRightStyle(workbook);
		XSSFCellStyle leftStyle = getCellLeftStyle(workbook);
		ExcelUtil.setMergeCellValue(sheet, rightStyle, rowIndex, 0, rowIndex, 1, "入库单号：");
		ExcelUtil.setMergeCellValue(sheet, leftStyle, rowIndex, 2, rowIndex, 4, bill.getId());
		ExcelUtil.setMergeCellValue(sheet, rightStyle, rowIndex, 5, rowIndex, 6, "入库日期：");
		ExcelUtil.setMergeCellValue(sheet, leftStyle, rowIndex, 7, rowIndex, 9, bill.getInStockDate());
		ExcelUtil.setMergeCellValue(sheet, rightStyle, rowIndex, 10, rowIndex, 11, "仓库：");
		ExcelUtil.setMergeCellValue(sheet, leftStyle, rowIndex, 12, rowIndex, 13, bill.getWareHouse());
		
		// 第三行
		rowIndex ++;
		ExcelUtil.setMergeCellValue(sheet, rightStyle, rowIndex, 0, rowIndex, 1, "供货单位：");
		ExcelUtil.setMergeCellValue(sheet, leftStyle, rowIndex, 2, rowIndex, 4, bill.getSupplyCompany());
		ExcelUtil.setMergeCellValue(sheet, rightStyle, rowIndex, 5, rowIndex, 6, "备注：");
		ExcelUtil.setMergeCellValue(sheet, leftStyle, rowIndex, 7, rowIndex, 13, bill.getRemark());
		
		// 第四行
		rowIndex ++;
		XSSFCellStyle centerStyle = getCellCenterStyle(workbook);
		ExcelUtil.setBorder(centerStyle);
		ExcelUtil.setMergeCellValue(sheet, centerStyle, rowIndex, 0, rowIndex, 1, "存货编号");
		ExcelUtil.setMergeCellValue(sheet, centerStyle, rowIndex, 2, rowIndex, 5, "存货名称");
		ExcelUtil.setMergeCellValue(sheet, centerStyle, rowIndex, 6, rowIndex, 7, "规格型号");
		ExcelUtil.setMergeCellValue(sheet, centerStyle, rowIndex, 8, rowIndex, 9, "数量");
		ExcelUtil.setMergeCellValue(sheet, centerStyle, rowIndex, 10, rowIndex, 11, "单价");
		ExcelUtil.setMergeCellValue(sheet, centerStyle, rowIndex, 12, rowIndex, 13, "金额");
		
		XSSFCellStyle rightBorderStyle = getCellRightStyle(workbook);
		XSSFCellStyle leftBorderStyle = getCellLeftStyle(workbook);
		ExcelUtil.setBorder(rightBorderStyle);
		ExcelUtil.setBorder(leftBorderStyle);
		rowIndex ++;
		List<InStockDetail> details = bill.getDetails();
		if (null != details && details.size() > 0) {
			double sumNum = 0.0;
			double sumMoney = 0.0;
			for (InStockDetail detail : details) {
				sumNum += detail.getNum();
				sumMoney += detail.getMoney();
				ExcelUtil.setMergeCellValue(sheet, leftBorderStyle, rowIndex, 0, rowIndex, 1, detail.getGoodsId()); // 存货编号
				ExcelUtil.setMergeCellValue(sheet, leftBorderStyle, rowIndex, 2, rowIndex, 5, detail.getGoodsName()); // 存货名称
				ExcelUtil.setMergeCellValue(sheet, leftBorderStyle, rowIndex, 6, rowIndex, 7, detail.getModel()); // 规格型号
				ExcelUtil.setMergeCellValue(sheet, rightBorderStyle, rowIndex, 8, rowIndex, 9, Double.toString(detail.getNum())); // 数量
				ExcelUtil.setMergeCellValue(sheet, rightBorderStyle, rowIndex, 10, rowIndex, 11, Double.toString(detail.getUnitPrice())); // 单价
				ExcelUtil.setMergeCellValue(sheet, rightBorderStyle, rowIndex, 12, rowIndex, 13, Double.toString(detail.getMoney())); // 金额
				
				rowIndex ++;
			}

			// 合计：
			ExcelUtil.setMergeCellValue(sheet, leftBorderStyle, rowIndex, 0, rowIndex, 1, "合计："); 
			ExcelUtil.setMergeCellValue(sheet, leftBorderStyle, rowIndex, 2, rowIndex, 5, ""); 
			ExcelUtil.setMergeCellValue(sheet, leftBorderStyle, rowIndex, 6, rowIndex, 7, ""); 
			ExcelUtil.setMergeCellValue(sheet, rightBorderStyle, rowIndex, 8, rowIndex, 9, Double.toString(sumNum)); 
			ExcelUtil.setMergeCellValue(sheet, rightBorderStyle, rowIndex, 10, rowIndex, 11, ""); 
			ExcelUtil.setMergeCellValue(sheet, rightBorderStyle, rowIndex, 12, rowIndex, 13, Double.toString(sumMoney)); 
		}
		
		rowIndex ++;
		ExcelUtil.setMergeCellValue(sheet, leftStyle, rowIndex, 0, rowIndex, 2, "业务员：");
		ExcelUtil.setMergeCellValue(sheet, leftStyle, rowIndex, 3, rowIndex, 6, "制单人："); 
		ExcelUtil.setMergeCellValue(sheet, leftStyle, rowIndex, 7, rowIndex, 10, "审核人："); 
		ExcelUtil.setMergeCellValue(sheet, leftStyle, rowIndex, 11, rowIndex, 13, "记账人："); 
		
		
		// 生成数据行	
		ByteArrayOutputStream out = null;
		InputStream inputStream = null;
		try {
			out = new ByteArrayOutputStream();
			workbook.write(out);
			out.flush();
			byte[] outByte = out.toByteArray();
			inputStream = new ByteArrayInputStream(outByte, 0, outByte.length);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				workbook.close();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return inputStream;
	}
	
}
