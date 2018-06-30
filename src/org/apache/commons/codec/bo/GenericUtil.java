package org.apache.commons.codec.bo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericUtil {
	public static Class getSuperClassGenricType(Class c) {
		Type type = c.getGenericSuperclass();
		Type[] types = ((ParameterizedType) type).getActualTypeArguments();
		return (Class) types[0];
	}
}
