package org.apache.commons.codec.bo;

import org.apache.commons.codec.po.Newscomment;
import org.apache.struts.action.ActionForm;

public abstract interface INewsCommentManager extends IBaseManager<Newscomment> {
	public abstract Newscomment getJsonOrObjet(Object paramObject,
			ActionForm paramActionForm);
}
