package org.apache.commons.codec.data;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DataAobject extends HibernateDaoSupport implements IDataAobject {
	public void save(Object object) throws DataAccessException {
		getHibernateTemplate().save(object);
	}

	public void update(Object object) throws DataAccessException {
		getHibernateTemplate().update(object);
	}

	public void delete(Class clazz, Serializable id) throws DataAccessException {
		getHibernateTemplate().delete(get(clazz, id));
	}

	public Object get(Class clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	public List findByCriteria(DetachedCriteria dc) {
		return getHibernateTemplate().findByCriteria(dc);
	}

	public List findByExample(Object object) {
		return getHibernateTemplate().findByExample(object);
	}
}