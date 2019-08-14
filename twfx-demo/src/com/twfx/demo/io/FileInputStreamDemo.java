/**
 * 文件名：@FileInputStreamDemo.java <br/>
 * 包名：com.twfx.demo.io <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 类名：FileInputStreamDemo <br />
 *
 * 功能：
 *
 * @author twfx <br />
 *         创建时间：2019年8月14日 上午10:29:49 <br />
 * @version 2019年8月14日
 */
public class FileInputStreamDemo {

	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年8月14日 上午10:30:11 <br/>
	 */
	public static String read(String filePath) {
		StringBuilder sb = new StringBuilder();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			int dataLength = fis.available();
			byte[] bs = new byte[dataLength];
			int count = 0;
			while ((count = fis.read(bs)) != -1) {
				sb.append(new String(bs, 0, count));
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null != fis) {
				try {
					fis.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(read("F:/text.txt"));
	}
}
