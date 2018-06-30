package org.apache.commons.codec.bo;

import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.po.Newscomment;
import org.apache.struts.action.ActionForm;

public class NewscommentManager extends BaseMananger<Newscomment> implements
		INewsCommentManager {
	public Newscomment getJsonOrObjet(Object json, ActionForm form) {
		Newscomment bean = new Newscomment();
		if (json != null) {
			new JSONObject();
			JSONObject object = JSONObject.fromObject(json);
			bean = (Newscomment) JSONObject.toBean(object, Newscomment.class);
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