package org.apache.commons.codec.bo;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.commons.codec.data.IDataAobject;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

public class BaseMananger<T> implements IBaseManager<T> {
	static final String SUCCESS = Messages.getString("UserMananger.success");
	static final String FAILED = Messages.getString("UserMananger.failed");
	String flag = FAILED;
	IDataAobject dao;
	protected Class<T> entityClass;

	public void setDao(IDataAobject dao) {
		this.dao = dao;
	}

	public BaseMananger() {
		this.entityClass = GenericUtil.getSuperClassGenricType(getClass());
	}

	public Class<T> getEntityClass() {
		return this.entityClass;
	}

	public String save(Object object) {
		try {
			this.dao.save(object);
			this.flag = SUCCESS;
		} catch (DataAccessException e) {
			this.flag = FAILED;
			e.printStackTrace();
		}
		return this.flag;
	}

	public String update(Object object) {
		try {
			this.dao.update(object);
			this.flag = SUCCESS;
		} catch (DataAccessException e) {
			this.flag = FAILED;
			e.printStackTrace();
		}
		return this.flag;
	}

	public <T> T findOne(Serializable id) {
		return (T) this.dao.get(getEntityClass(), id);
	}

	public String delete(Serializable id) {
		try {
			this.dao.delete(getEntityClass(), id);
			this.flag = SUCCESS;
		} catch (DataAccessException e) {
			this.flag = FAILED;
			e.printStackTrace();
		}
		return this.flag;
	}

	public List findByAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		List list = this.dao.findByCriteria(dc);
		return list;
	}

	public List findByProperty(boolean flag, Object[][] objects) {
		DetachedCriteria dc = getDC(flag, objects);
		List list = this.dao.findByCriteria(dc);
		return list;
	}

	public List findByName(String key, Object value, boolean flag) {
		
		try {
			value = new String(value.toString().trim().getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(key+"/"+value);
		Object[] objects = { key, value };
		List list = findByProperty(flag, new Object[][] { objects });
		return list;
	}

	DetachedCriteria getDC(boolean flag, Object[][] objects) {
		DetachedCriteria dc = DetachedCriteria.forClass(getEntityClass());
		for (Object[] objs : objects) {
			if (flag) {
				dc
						.add(Restrictions.like((String) objs[0], "%" + objs[1]
								+ "%"));
				return dc;
			}
			dc.add(Restrictions.eq((String) objs[0], objs[1]));
		}
		return dc;
	}

	public List findByExample(Object object) {
		List list = this.dao.findByExample(object);
		return list;
	}
}