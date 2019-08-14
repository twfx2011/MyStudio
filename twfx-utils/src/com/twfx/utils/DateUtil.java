/**
 * 文件名：@DateUtil.java <br/>
 * 包名：com.twfx.utils <br/>
 * 项目名：CommUtils <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 类名：DateUtil  <br />
 *
 * 功能：日期工具类
 *
 * @author twfx <br />
 * 创建时间：2016-12-22 下午05:32:43  <br />
 * @version 2016-12-22
 */
public class DateUtil {

	/** yyyy-MM-dd HH:mm:ss日期格式 */
	public final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/** yyyy-MM-dd日期格式 */
	public final static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 功能：把日期按指定格式转换<br/>
	 *
	 * @author twfx
	 * @version 2017年9月10日 下午6:22:31 <br/>
	 */
	public static String dateToStr(Date date, String dateFormat) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.format(date);
	}
	
	/**
	 * 功能：把时间按指定格式转换<br/>
	 *
	 * @author twfx
	 * @version 2017年9月10日 下午6:22:31 <br/>
	 */
	public static String timeToStr(Date time, String timeFormat) {
		SimpleDateFormat format = new SimpleDateFormat(timeFormat);
		return format.format(time);
	}
	
	/** 
	 * 功能：把日期按默认格式转换<br/>
	 *
	 * @author twfx
	 * @version 2017年9月10日 下午6:16:50 <br/>
	 */
	public static String dateToStr(Date date) {
		return sdfDate.format(date);
	}
	
	/** 
	 * 功能：把时间按指定默认格式转换<br/>
	 *
	 * @author twfx
	 * @version 2017年9月10日 下午6:16:50 <br/>
	 */
	public static String timeToStr(Date time) {
		return sdfTime.format(time);
	}
	
	/** 
	 * 功能：获得当前日期(字符串)<br/>
	 *
	 * @author twfx
	 * @version 2017年9月10日 下午6:16:50 <br/>
	 */
	public static String getNowDateStr() {
		return sdfDate.format(new Date());
	}
	
	/** 
	 * 功能：获得当前日期(字符串)<br/>
	 *
	 * @author twfx
	 * @version 2017年9月10日 下午6:16:50 <br/>
	 */
	public static String getNowTimeStr() {
		return sdfTime.format(new Date());
	}
	
	/**
	 * 功能：返回两个日期相差的天数<br/>
	 *
	 * @author twfx
	 * @version 2016-12-22 下午06:02:47 <br/>
	 */
	public static long dayNum(String startDate, String endDate) throws Exception{
		Date sdate = sdfDate.parse(startDate);    
		Date edate = sdfDate.parse(endDate);     
		return (edate.getTime() - sdate.getTime())/(24 * 60 * 60 * 1000);
	}
	
	/**
	 * 功能：计算指定日期加上指定天数后的日期<br/>
	 * date参数格式：yyyy-MM-dd
	 * @author twfx
	 * @version 2016-12-30 上午09:37:51 <br/>
	 */
	public static String addDate(String date, int days) throws Exception {
		Calendar now = Calendar.getInstance();
		now.setTime(sdfDate.parse(date));
		now.add(Calendar.DATE, days);
		return sdfDate.format(now.getTime());
	}
	
	/**
	 * 功能：计算指定日期加上指定天数后的日期<br/>
	 * date参数格式：yyyy-MM-dd
	 * @author twfx
	 * @version 2016-12-30 上午09:37:51 <br/>
	 */
	public static String addDate(String date, SimpleDateFormat sdf, int days) throws Exception {
		Calendar now = Calendar.getInstance();
		now.setTime(sdf.parse(date));
		now.add(Calendar.DATE, days);
		return sdf.format(now.getTime());
	}
	
	/**
	 * 功能：判断是否是闰年<br/>
	 * 
	 * @author twfx
	 * @version 2014-9-27 下午03:39:17 <br/>
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && ((year % 100 != 0) || (year % 400 == 0))) {
			return true;
		}
		return false;
	}
}
