package org.demo.wzs.validate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * <p>
 * 通用工具类
 * </p>
 */
public class Tools {

	public static final String SEP = "\\^";
	public static final String COMMA = ",";
	public static final String VERTICAL = "\\|";
	public static final String COLON = ":";
	public static final String MINUS = "-";

	/**
	 * list转String，用","分隔
	 *
	 * @param stringList
	 * @return
	 */
	public static String list2String(List<String> stringList) {
		if (stringList == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (String string : stringList) {

			if (flag) {
				result.append(COMMA);
			} else {
				flag = true;
			}
			result.append(string);
		}
		return result.toString();
	}

	/**
	 * list转String，用"^"分隔
	 *
	 * @param stringList
	 * @return
	 */
	public static String list2StringBySep(List<String> stringList) {
		if (stringList == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (String string : stringList) {

			if (flag) {
				result.append(SEP);
			} else {
				flag = true;
			}
			result.append(string);
		}
		return result.toString();
	}

	public static List<String> str2List(String listText) {
		if (listText == null || listText.equals("")) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		String[] text = listText.split(SEP);
		for (String str : text) {
			list.add(str);
		}
		return list;
	}

	public static String[] str2Array(String listText) {
		if (listText == null || listText.equals("")) {
			return null;
		}
		String[] text = listText.split(COMMA);

		return text;
	}

	/**
	 * 返回当天结束时间，用于默认结束时间为空的地方
	 *
	 * @return
	 */
	public static Date endDayTime() {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		return todayEnd.getTime();

	}

	// 支持0-2位小数数字,大于0
	public static boolean isNumberNoZero(String str) {
		String regex = "^(?!0(\\d|\\.0+$|$))\\d+(\\.\\d{1,2})?$"; // 大于0
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str);
		// match.find()
		return match.matches();
	}

	// 支持0-2位小数数字
	public static boolean isNumber(String str) {
		String regex = "^([0-9]+(.[0-9]{1,2})?)|([0-9]+(.[0-9]{1,2})?)$"; // 包括0，0.00
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str);
		// match.find()
		return match.matches();
	}

	// 正整数，不包括0
	public static boolean isInt(String str) {
		String regex = "^[0-9]*[1-9][0-9]*$"; //
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str);
		// match.find()
		return match.matches();
	}

	public static boolean isDateTime(String value,String format) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			dateFormat.parse(value);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}
