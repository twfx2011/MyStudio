/**
 * 文件名：@IdentityUtil.java <br/>
 * 包名：com.twfx.utils <br/>
 * 项目名：CommUtils <br/>
 * @author twfx <br/>
 */
package com.twfx.utils;

import java.util.Arrays;
import java.util.List;

/**
 * 类名：IdentityUtil <br />
 * 
 * 功能：身份证号校验工具类
 * 
 * @author twfx <br />
 *         创建时间：2016-12-22 下午06:12:51 <br />
 * @version 2016-12-22
 */
public class IdentityUtil {

	/**
	 * 功能：身份证号合法校验<br/>
	 * 
	 * @author twfx
	 * @version 2016-12-22 下午06:14:12 <br/>
	 */
	public static String check(String ID) {
		String[] errors = new String[] { "OK", "身份证号码位数不正确！", "身份证号码出生日期超出范围或含有非法字符！", "身份证号码校验错误！", "身份证地区非法！" };
		// 所有地区的身份证号前两位
		List<String> areas = Arrays.asList("11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54",
				"61", "62", "63", "64", "65", "71", "81", "82", "91");

		// 以空串截取身份证号
		String[] id_array = ID.split("");
		// 地区检验
		if (!areas.contains(ID.substring(0, 2))) {
			return errors[4];
		}

		String regex = null;
		// 身份号码位数及格式检验
		switch (ID.length()) {
		case 15:
			// 15位身份证校验
			int year2 = Integer.parseInt(ID.substring(6, 8)) + 1900;
			if (year2 % 4 == 0 || (year2 % 100 == 0 && year2 % 4 == 0)) {
				// 测试出生日期的合法性
				regex = "^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$";
			} else {
				// 测试出生日期的合法性
				regex = "^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$";
			}

			if (!ID.matches(regex)) {
				return errors[2];
			}
			break;
		case 18:
			// 18位身份号码检测
			// 出生日期的合法性检查
			int year4 = Integer.parseInt(ID.substring(6, 10));
			if (year4 % 4 == 0 || (year4 % 100 == 0 && year4 % 4 == 0)) {
				// 闰年出生日期的合法性正则表达式
				regex = "^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9|X|x]$";

			} else {
				// 平年出生日期的合法性正则表达式
				regex = "^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9|X|x]$";
			}
			// 测试出生日期的合法性
			if (ID.matches(regex)) {
				// 计算校验位
				int sum = (Integer.parseInt(id_array[1]) + Integer.parseInt(id_array[11])) * 7 + (Integer.parseInt(id_array[2]) + Integer.parseInt(id_array[12])) * 9
						+ (Integer.parseInt(id_array[3]) + Integer.parseInt(id_array[13])) * 10 + (Integer.parseInt(id_array[4]) + Integer.parseInt(id_array[14])) * 5
						+ (Integer.parseInt(id_array[5]) + Integer.parseInt(id_array[15])) * 8 + (Integer.parseInt(id_array[6]) + Integer.parseInt(id_array[16])) * 4
						+ (Integer.parseInt(id_array[7]) + Integer.parseInt(id_array[17])) * 2 + Integer.parseInt(id_array[8]) * 1 + Integer.parseInt(id_array[9]) * 6 + Integer.parseInt(id_array[10])
						* 3;
				// 余数
				int remainder = sum % 11;
				String flag = "F";
				String checkCode = "10X98765432";
				flag = checkCode.substring(remainder, remainder + 1);// 判断校验位
				// 校验码错误
				if (!flag.equals(id_array[18])) // 检测ID的校验位
				{
					return errors[3];
				}
			} else {
				// 出生日期不合法
				return errors[2];
			}
			break;
		default:
			// 身份证号尾数不正确
			return errors[1];
		}
		// 验证通过
		return errors[0];
	}

	/**
	 * 功能：身份证简单校验：只校验身份证位数、出生日期和校验位<br/>
	 *
	 * @author twfx
	 * @version 2016-1-2 下午03:28:46 <br/>
	 */
	public static String simpleCheck(String creditID) {
		String[] errors = new String[]{ "OK", "身份证号码位数不正确！", "身份证号码出生日期超出范围或含有非法字符！", "身份证号码校验错误！"};
		String regex = null;
		// 身份号码位数及格式检验
		switch (creditID.length()) {
			case 15:
				// 15位身份证校验
				int year2 = Integer.parseInt(creditID.substring(6, 8)) + 1900;
				if (year2 % 4 == 0 || (year2 % 100 == 0 && year2 % 4 == 0)) {
					// 测试出生日期的合法性
					regex = "^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$";
				}else {
					// 测试出生日期的合法性
					regex = "^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$";
				}

				if (!creditID.matches(regex)) {
					return errors[2];
				}
				break;
			case 18:
				// 18位身份号码检测
				// 出生日期的合法性检查
				int year4 = Integer.parseInt(creditID.substring(6, 10));
				if (year4 % 4 == 0 || (year4 % 100 == 0 && year4 % 4 == 0)) {
					// 闰年出生日期的合法性正则表达式
					regex = "^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9|X|x]$";

				}else {
					// 平年出生日期的合法性正则表达式
					regex = "^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9|X|x]$";
				}
				// 测试出生日期的合法性
				if (creditID.matches(regex)) {
					String[] id_array = creditID.split("");
					int sum = Integer.parseInt(id_array[1]) * 7 + Integer.parseInt(id_array[2]) * 9 + Integer.parseInt(id_array[3]) * 10 + Integer.parseInt(id_array[4]) * 5 + Integer.parseInt(id_array[5]) * 8 + Integer.parseInt(id_array[6]) * 4
							+ Integer.parseInt(id_array[7]) * 2 + Integer.parseInt(id_array[8]) * 1 + Integer.parseInt(id_array[9]) * 6 + Integer.parseInt(id_array[10]) * 3 + Integer.parseInt(id_array[11]) * 7 + Integer.parseInt(id_array[12]) * 9
							+ Integer.parseInt(id_array[13]) * 10 + Integer.parseInt(id_array[14]) * 5 + Integer.parseInt(id_array[15]) * 8 + Integer.parseInt(id_array[16]) * 4 + Integer.parseInt(id_array[17]) * 2;
					int remainder = 12 - sum % 11;
					String checkBit = remainder + "";
					if (remainder == 12) { // 取模等于12时，校验位为1
						checkBit = "1";
					}
					if (remainder == 11) { // 取模等于11时，校验位为0
						checkBit = "0";
					}
					if (remainder == 10) { // 取模等于10时，校验位为X
						checkBit = "X";
					}

					if (!checkBit.equals(id_array[18])) {
						return errors[3];
					}
				}else {
					// 出生日期不合法
					return errors[2];
				}
				break;
			default:
				// 身份证号位数不正确
				return errors[1];
		}
		// 验证通过
		return errors[0];
	}
	
	/**
	 * 功能：身份证号简单检验：只校验校验位<br/>
	 *
	 * @author twfx
	 * @version 2016-12-22 下午06:23:18 <br/>
	 */
	public static boolean simpleCheckBit(String ID) {
		String[] id_array = ID.split("");
		int totalNum = Integer.parseInt(id_array[1]) * 7 + Integer.parseInt(id_array[2]) * 9 + Integer.parseInt(id_array[3]) * 10 + Integer.parseInt(id_array[4]) * 5 + Integer.parseInt(id_array[5])
				* 8 + Integer.parseInt(id_array[6]) * 4 + Integer.parseInt(id_array[7]) * 2 + Integer.parseInt(id_array[8]) * 1 + Integer.parseInt(id_array[9]) * 6 + Integer.parseInt(id_array[10])
				* 3 + Integer.parseInt(id_array[11]) * 7 + Integer.parseInt(id_array[12]) * 9 + Integer.parseInt(id_array[13]) * 10 + Integer.parseInt(id_array[14]) * 5
				+ Integer.parseInt(id_array[15]) * 8 + Integer.parseInt(id_array[16]) * 4 + Integer.parseInt(id_array[17]) * 2;
		int modNum = 12 - totalNum % 11;
		String checkBit = modNum + "";
		if (modNum == 12) { // 取模等于12时，校验位为1
			checkBit = "1";
		}
		if (modNum == 11) { // 取模等于11时，校验位为0
			checkBit = "0";
		}
		if (modNum == 10) { // 取模等于10时，校验位为X
			checkBit = "X";
		}
		if (checkBit.equals(id_array[18])) {
			return true;
		}
		return false;
	}
}
