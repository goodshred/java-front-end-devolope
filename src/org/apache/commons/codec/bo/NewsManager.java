package org.apache.commons.codec.bo;

import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.po.News;
import org.apache.struts.action.ActionForm;

public class NewsManager extends BaseMananger<News> implements INewsManager {
	public News getJsonOrObjet(Object json, ActionForm form) {
		News bean = new News();
		if (json != null) {
			new JSONObject();
			JSONObject object = JSONObject.fromObject(json);
			bean = (News) JSONObject.toBean(object, News.class);
			return bean;
		}
		try {
			BeanUtils.copyProperties(bean, form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}