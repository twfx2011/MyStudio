/**
 * 文件名：@ExcelPrintUtil.java <br/>
 * 包名：com.twfx.print.utils <br/>
 * 项目名：twfx-print <br/>
 * @author twfx <br/>
 */
package com.twfx.print.utils;

import java.io.File;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import jp.ne.so_net.ga2.no_ji.jcom.ReleaseManager;
import jp.ne.so_net.ga2.no_ji.jcom.excel8.ExcelApplication;
import jp.ne.so_net.ga2.no_ji.jcom.excel8.ExcelWorkbook;
import jp.ne.so_net.ga2.no_ji.jcom.excel8.ExcelWorkbooks;
import jp.ne.so_net.ga2.no_ji.jcom.excel8.ExcelWorksheet;

/**
 * 类名：ExcelPrintUtil  <br />
 *
 * 功能：Excel打印
 * 打印模板制作步骤：先用excel文件创建打印模板，然后用java实现生成excel模板并打印
 *
 * @author twfx <br />
 * 创建时间：2019年8月19日 上午11:31:31  <br />
 * @version 2019年8月19日
 */
public class ExcelPrintUtil {

	/**
	 * 功能：通过jcom打印Excel文件，jcom目前仅支持32位系统，如果是64位系统请使用jacob<br/>
	 * 需要将jcom.dll文件放到JDK的bin目录下
	 * @author 孟雪勤
	 * @version 2015年12月7日 上午9:45:45 <br/>
	 */
	public static boolean print_jcom(String filePath) {
		File file = new File(filePath);
        ReleaseManager rm = new ReleaseManager();
        try {
            ExcelApplication excel = new ExcelApplication(rm);

            ExcelWorkbooks xlBooks = excel.Workbooks();
            ExcelWorkbook xlBook = xlBooks.Open(filePath);
            ExcelWorksheet xlSheet = excel.ActiveSheet();
            
            xlSheet.PrintOut();

            xlBook.Close(false, null, false);
            excel.Quit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            rm.release();
            if (file.exists()) {
            	file.delete();
            }
        }
    }
	
	/**
	 * 功能：通过jacob打印Excel文件，jacob可以支持32位和64位系统<br/>
	 * 把dll文件放在%JAVA_HOME%\bin下（注意系统是32位还是64位），也可以放在C:\Windows\System32下，
	 * 如果是64位应该放在C:\Windows\SysWOW64 下。建议放在jdk的bin目录下
	 * @author twfx
	 * @version 2019年8月19日 上午11:55:17 <br/>
	 */
	public static boolean print_jacob(String filePath) {
		ActiveXComponent xl = new ActiveXComponent("Excel.Application");
		File file = new File(filePath);
		try {
			ComThread.InitSTA();
			// 不打开文档
			Dispatch.put(xl, "Visible", new Variant(false));
			Dispatch workbooks = (Dispatch) xl.getProperty("Workbooks").toDispatch();
			// 判断文件是否存在
			if (file.exists()) {
				Dispatch excel = Dispatch.call(workbooks, "Open", filePath).toDispatch();
				Dispatch.call(excel,"PrintOut");
				// 关闭文档
				Dispatch.call(excel, "Close", new Variant(false)); 
				excel = null;
			}
			xl.invoke("Quit",new Variant[0]);
			xl = null;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			// 始终释放资源
			ComThread.Release();
			if (null != file) {
				file.delete();
			}
		}
	}
	
	public static void main(String[] args) {
		File file = new File("F:\\1566360849385.xlsx");
		file.delete();
	}
}
