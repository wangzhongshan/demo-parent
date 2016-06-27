package org.demo.wzs.validate;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class ValidateTools {

	private static final String DEFAULT_DATE_TIME_FORMAT = new String("yyyyMMddHHmmss");

	public static Map<String, List<String>> validate(Object req) {

		Map<String, List<String>> errors = new HashMap<String, List<String>>();

		Field[] fields = req.getClass().getDeclaredFields();

		List<String> requiredList = new ArrayList<String>();
		List<String> lengthList = new ArrayList<String>();
		List<String> numberList = new ArrayList<String>();

		errorInfo(req, fields, requiredList, lengthList, numberList);

		// 父类字段
		if (req.getClass().getGenericSuperclass() != null) {
			Class<?> superClass = req.getClass().getSuperclass();// 父类
			Field[] superFields = superClass.getDeclaredFields();// 父类字段
			errorInfo(req, superFields, requiredList, lengthList, numberList);
		}
		errors.put(ValidateEnum.REQUIRED_FIELD_NOT_EXIST.getCode(), requiredList); // 必填字段未填
		errors.put(ValidateEnum.FIELD_LENGTH_EXCEEDS_LIMIT.getCode(), lengthList); // 字段长度超过限制
		errors.put(ValidateEnum.FIELD_TYPE_ERROR.getCode(), numberList); // 字段类型错误
		return errors;

	}

	private static String getValue(String field, Object req) {
		String result = null;
		String getMethodName = "get" + toFirstLetterUpperCase(field);
		try {
			result = (String) req.getClass().getMethod(getMethodName).invoke(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	private static boolean isNull(String field, Object req) {
		boolean result = false;

		if (StringUtils.isEmpty(getValue(field, req))) {
			result = true;
		}

		return result;
	}

	private static boolean length(String field, Object req, int maxLength) {
		boolean result = false;
		String value = getValue(field, req);

		if (value != null && value.length() > maxLength) {
			result = true;
		}

		return result;
	}

	private static boolean number(String field, Object req) {
		boolean result = false;
		String value = getValue(field, req);

		if (value != null) {
			result = Tools.isNumber(value);
		}

		return result;
	}

	private static boolean numberNoZero(String field, Object req) {
		boolean result = false;
		String value = getValue(field, req);

		if (value != null) {
			result = Tools.isNumberNoZero(value);
		}

		return result;
	}

	private static boolean dateTime(String field, Object req) {
		boolean result = false;
		String value = getValue(field, req);

		if (value != null) {
			result = Tools.isDateTime(value, DEFAULT_DATE_TIME_FORMAT);
		}

		return result;
	}

	private static boolean integer(String field, Object req) {
		boolean result = false;
		String value = getValue(field, req);

		if (value != null) {
			result = Tools.isInt(value);
		}

		return result;
	}

	public static String toFirstLetterUpperCase(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		String firstLetter = str.substring(0, 1).toUpperCase();
		return firstLetter + str.substring(1, str.length());
	}

	private static void errorInfo(Object req, Field[] fields, List<String> requiredList, List<String> lengthList,
			List<String> numberList) {
		for (Field field : fields) {
			if (field.isAnnotationPresent(Validate.class)) {// 只处理包含注解为Validate的属性名称
				Validate validateUtil = field.getAnnotation(Validate.class);

				if (validateUtil.required() == true)
					if (true == isNull(field.getName(), req)) {
						requiredList.add(validateUtil.name());
					}
				if (StringUtils.isEmpty(getValue(field.getName(), req))) {
					continue; // 没有数据的字段，跳过长度和数字的检查
				}
				ValidateTypeKind type = validateUtil.type();
				if (ValidateTypeKind.Length == type) {
					if (true == length(field.getName(), req, validateUtil.maxLength())) {
						lengthList.add(validateUtil.name());
					}
				}
				if (ValidateTypeKind.Number == type) {
					if (true == length(field.getName(), req, validateUtil.maxLength())) {
						// 数字也要检查长度
						lengthList.add(validateUtil.name());
					}
					// 如果是必填的，不能是0, 0.00, 0.0
					if (validateUtil.required() == true) {
						if (!numberNoZero(field.getName(), req)) {
							numberList.add(validateUtil.name());
						}
					} else {
						if (!number(field.getName(), req)) {
							numberList.add(validateUtil.name());
						}
					}
				}

				if (ValidateTypeKind.Date == type) {
					if (true == length(field.getName(), req, validateUtil.maxLength())) {
						// 数字也要检查长度
						lengthList.add(validateUtil.name());
					}
					if (!dateTime(field.getName(), req)) {
						numberList.add(validateUtil.name());
					}
				}

				if (ValidateTypeKind.Integer == type) {
					if (true == length(field.getName(), req, validateUtil.maxLength())) {
						// 数字也要检查长度
						lengthList.add(validateUtil.name());
					}
					if (!integer(field.getName(), req)) {
						numberList.add(validateUtil.name());
					}
					// 如果是必填的，不能<=0
					if (validateUtil.required() == true) {
						BigDecimal zero = new BigDecimal("0");
						BigDecimal data = new BigDecimal(getValue(field.getName(), req));
						if (data.compareTo(zero) <= 0) {
							requiredList.add(validateUtil.name());
						}
					}
				}

			}
		}
	}

}
