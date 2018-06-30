package org.apache.commons.codec.bo;

import org.apache.commons.codec.po.Newstype;
import org.apache.struts.action.ActionForm;

public abstract interface INewsTypeManager extends IBaseManager<Newstype> {
	public abstract Newstype getJsonOrObjet(Object paramObject,
			ActionForm paramActionForm);
}
