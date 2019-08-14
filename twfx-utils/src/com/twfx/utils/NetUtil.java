/**
 * 文件名：@NetUtil.java <br/>
 * 包名：com.twfx.utils <br/>
 * 项目名：twfx-utils <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * 类名：NetUtil  <br />
 *
 * 功能：网络工具类
 *
 * @author twfx <br />
 * 创建时间：2017年9月10日 下午6:09:04  <br />
 * @version 2017年9月10日
 */
public class NetUtil {

	/**
	 * 功能：检测URL是否联通<br/>
	 *
	 * @author twfx
	 * @version 2018年9月30日 上午8:20:01 <br/>
	 */
	public static boolean isURLNetOK(String urlStr) {
         try {
        	 URL url = new URL(urlStr);
	         InputStream in = url.openStream();
	         in.close();
        } catch (IOException e) {
        	return false;
        }
        return true;
	}
	
	/**
	 * 功能：检测本机网络是否联通<br/>
	 *
	 * @author twfx
	 * @version 2015-7-11 下午05:23:04 <br/>
	 * @throws UnknownHostException 
	 */
	public static boolean isNetOk() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress();//获得本机IP
			if (ip.equals("127.0.0.1")) {
				return false;
			}
		} catch (UnknownHostException e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 功能：网络是否联通<br/>
	 *
	 * @author twfx
	 * @version 2017年9月10日 下午5:55:43 <br/>
	 */
	public static boolean isNetOk(String ipAddr) {
        boolean reachable = false; 
        try {   
             InetAddress address = InetAddress.getByName(ipAddr); 
             reachable = address.isReachable(5000);  
         } catch (Exception e) {  
        	 return false;
         }  
         return reachable;
    }
	
	/**
	 * 功能：获得本机IP地址<br/>
	 *
	 * @author twfx
	 * @version 2017年2月22日 上午10:38:57 <br/>
	 */
	public static String getIP() {
        InetAddress ipAddr = null;
        try {
        	ipAddr = InetAddress.getLocalHost();
        	return ipAddr.getHostAddress();
        } catch (Exception e) {
        	return null;
        }
    }
	
	/**
	 * 功能：获得本机MAC地址<br/>
	 *
	 * @author twfx
	 * @version 2017年2月22日 上午10:40:21 <br/>
	 */
	public static String getMAC(){
		try {
			InetAddress ia = InetAddress.getLocalHost();
			byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
			if (null == mac)
				return null;
			StringBuffer sb = new StringBuffer("");
			for(int i=0; i<mac.length; i++) {
				if(i!=0) {sb.append("-");}
				//字节转换为整数
				int temp = mac[i]&0xff;
				String str = Integer.toHexString(temp);
				if(str.length()==1) {
					sb.append("0"+str);
				}else {
					sb.append(str);
				}
			}
			return sb.toString().toUpperCase();
		}catch (Exception e) {
			return null;
		}
	}
}
