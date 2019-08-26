/**
 * 文件名：@ExcelUtil.java <br/>
 * 包名：com.twfx.excel.utils <br/>
 * 项目名：twfx-print <br/>
 * @author twfx <br/>
 */
package com.twfx.excel.utils;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 类名：ExcelUtil <br />
 *
 * 功能：Excel工具类
 *
 * @author twfx <br />
 *         创建时间：2019年8月20日 下午4:11:44 <br />
 * @version 2019年8月20日
 */
public class ExcelUtil {
	
	/**
	 * 功能：设置单元格边框<br/>
	 *
	 * @author twfx
	 * @version 2019年8月20日 下午4:25:48 <br/>
	 */
	public static void setBorder(XSSFCellStyle style) {
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
	}
	
	/**
	 * 功能：设置单元格的字体<br/>
	 *
	 * @author twfx
	 * @version 2019年8月21日 上午10:53:16 <br/>
	 */
	public static void setFont(XSSFWorkbook workbook, XSSFCellStyle style, int colorIndex, int fontSize, String fontName, short boldWeight) {
		// 创建字体
		XSSFFont font = workbook.createFont();
		font.setColor((short) colorIndex);// 字体颜色
		font.setFontHeightInPoints((short) fontSize);// 字体高度
		font.setFontName(fontName);// 字体
		font.setBoldweight(boldWeight);// 宽度
		style.setFont(font); // 设置字体
	}
	
	/**
	 * 功能：设置合并单元格后的样式与值<br/>
	 *
	 * @author twfx
	 * @version 2015-12-2 下午03:01:21 <br/>
	 */
	public static void setMergeCellValue(XSSFSheet sheet, XSSFCellStyle style, int startRow, int startCol, int endRow, int endCol, String value) {
		sheet.addMergedRegion(new CellRangeAddress(startRow, endRow, startCol, endCol));
		for (int row = startRow; row <= endRow; row++) {
			XSSFRow r = sheet.getRow(row);
			if (null == r) {
				r = sheet.createRow(row);
			}
			for (int col = startCol; col <= endCol; col++) {
				r.createCell(col).setCellStyle(style); // 设置单元格样式
			}
		}
		sheet.getRow(startRow).getCell(startCol).setCellValue(value);
	}

	/**
	 * 功能：设置单元格的样式与值<br/>
	 *
	 * @author twfx
	 * @version 2015-12-2 下午04:45:01 <br/>
	 */
	public static void setCellValue(XSSFSheet sheet, XSSFCellStyle style, int rowIndex, int colIndex, String value) {
		XSSFRow row = sheet.getRow(rowIndex);
		if (row == null)
			row = sheet.createRow(rowIndex);
		XSSFCell cell = row.createCell(colIndex);
		cell.setCellStyle(style);
		cell.setCellValue(value);
	}

}
