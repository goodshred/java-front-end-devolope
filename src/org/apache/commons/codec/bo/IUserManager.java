package org.apache.commons.codec.bo;

import org.apache.commons.codec.po.Users;
import org.apache.struts.action.ActionForm;

public abstract interface IUserManager extends IBaseManager<Users> {
	public abstract String login(Users paramUsers);

	public abstract Users getJsonOrObjet(Object paramObject,
			ActionForm paramActionForm);
}
