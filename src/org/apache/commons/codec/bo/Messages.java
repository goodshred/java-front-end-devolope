package org.apache.commons.codec.bo;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String BUNDLE_NAME = "org.apache.commons.codec.bo.messages";
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle("org.apache.commons.codec.bo.messages");

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
		}
		return '!' + key + '!';
	}
}