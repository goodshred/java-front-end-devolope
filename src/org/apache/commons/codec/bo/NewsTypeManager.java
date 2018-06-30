package org.apache.commons.codec.bo;

import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.po.Newstype;
import org.apache.struts.action.ActionForm;

public class NewsTypeManager extends BaseMananger<Newstype> implements
		INewsTypeManager {
	public Newstype getJsonOrObjet(Object json, ActionForm form) {
		Newstype bean = new Newstype();
		if (json != null) {
			new JSONObject();
			JSONObject object = JSONObject.fromObject(json);
			bean = (Newstype) JSONObject.toBean(object, Newstype.class);
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