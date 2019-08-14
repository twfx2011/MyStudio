/**
 * 文件名：@FileUtil.java <br/>
 * 包名：com.twfx.utils <br/>
 * 项目名：twfx2011 <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 类名：FileUtil  <br />
 *
 * 功能：文件工具类
 *
 * @author twfx <br />
 * 创建时间：2016-12-30 上午09:34:00  <br />
 * @version 2016-12-30
 */
public class FileUtil {

	/**
	 * 功能：将文件转换成二进制字节流<br/>
	 *
	 * @author twfx
	 * @version 2014-6-19 上午10:21:49 <br/>
	 */
	public static byte[] fileToByteArray(File file){
		if (null == file)
			return null;
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(file);
			int streamLength = fis.available();
			byte[] buffer = new byte[streamLength];
			fis.read(buffer, 0, streamLength);
			fis.close();
			return buffer;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 功能：下载文件名中文乱码转换<br/>
	 *
	 * @author twfx
	 * @version 2016-12-30 上午10:07:23 <br/>
	 */
	public static String getFileName(String fileName) {
		if (null == fileName || fileName.length() == 0)
			return null;
		try {
			return new String(fileName.getBytes(), "ISO8859-1");
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
