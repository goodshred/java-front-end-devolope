package org.apache.commons.codec.bo;

import org.apache.commons.codec.po.News;
import org.apache.struts.action.ActionForm;

public abstract interface INewsManager extends IBaseManager<News> {
	public abstract News getJsonOrObjet(Object paramObject,
			ActionForm paramActionForm);
}
