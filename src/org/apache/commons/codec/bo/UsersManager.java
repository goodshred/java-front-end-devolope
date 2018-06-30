package org.apache.commons.codec.bo;

import java.util.List;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.data.IDataAobject;
import org.apache.commons.codec.po.Users;
import org.apache.struts.action.ActionForm;

public class UsersManager extends BaseMananger<Users> implements IUserManager {
	public String login(Users user) {
		List list = this.dao.findByExample(user);
		if (list.size() > 0)
			this.flag = SUCCESS;
		else {
			this.flag = FAILED;
		}
		return this.flag;
	}

	public Users getJsonOrObjet(Object json, ActionForm form) {
		Users bean = new Users();
		if (json != null) {
			new JSONObject();
			JSONObject object = JSONObject.fromObject(json);
			bean = (Users) JSONObject.toBean(object, Users.class);
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