/**
 * 文件名：@ReadFile.java <br/>
 * 包名：com.twfx.demo.io <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 类名：ReadFile <br />
 *
 * 功能：BufferedReader读取文件内容示例
 *
 * @author twfx <br />
 *         创建时间：2019年8月14日 上午10:04:54 <br />
 * @version 2019年8月14日
 */
public class BufferedReaderDemo {

	/**
	 * 功能：读取文件<br/>
	 *
	 * @author twfx
	 * @version 2019年8月14日 上午10:05:47 <br/>
	 */
	public static String read(String filePath) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
			String s = null;
			while ((s = br.readLine()) != null) {
				sb.append(s).append("\n");
			}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
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
