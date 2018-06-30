package org.apache.commons.beanUtil;

import net.sf.json.JSONObject;

public class BeanUtil {
	public static String writer(Object object) {
		return "[" + JSONObject.fromObject(object).toString() + "]";
	}
}
