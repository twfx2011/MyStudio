/**
 * 文件名：@PrintUtil.java <br/>
 * 包名：com.mescs.baseinfo.utils <br/>
 * 项目名：mescs-baseinfo <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;

import java.io.File;
import java.io.FileInputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.event.PrintJobEvent;
import javax.print.event.PrintJobListener;

/**
 * 类名：PrintUtil  <br />
 *
 * 功能：小票打印工具类
 *
 * @author twfx <br />
 * 创建时间：2017年8月30日 下午3:50:45  <br />
 * @version 2017年8月30日
 */
public class PrintUtil {

	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2017年9月9日 上午9:57:44 <br/>
	 */
	public static void printUSB(String fileName){
		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
		
		PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
		
		try {
			if (null == defaultService)
				return;
			DocPrintJob job = defaultService.createPrintJob(); 
			job.addPrintJobListener(new PrintJobListener() {
				@Override
				public void printJobRequiresAttention(PrintJobEvent arg0) {
					System.out.println("printJobRequiresAttention");
				}

				@Override
				public void printJobNoMoreEvents(PrintJobEvent arg0) {
					System.out.println("printJobNoMoreEvents");
				}

				@Override
				public void printJobFailed(PrintJobEvent arg0) {
					System.out.println("printJobFailed");

				}

				@Override
				public void printJobCompleted(PrintJobEvent arg0) {
					System.out.println("printJobCompleted");
				}

				@Override
				public void printJobCanceled(PrintJobEvent arg0) {
					System.out.println("printJobCanceled");
				}
				@Override
				public void printDataTransferCompleted(PrintJobEvent arg0) {
					System.out.println("printDataTransferCompleted");
				}
			});

			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file); 
			DocAttributeSet das = new HashDocAttributeSet();
			Doc doc = new SimpleDoc(fis,flavor, das); 
			doc = new SimpleDoc(fis,flavor,das);
			job.print(doc, pras); 
			fis.close();
			file.delete();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
