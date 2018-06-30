package org.apache.commons.codec.data;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;

public abstract interface IDataAobject {
	public abstract void save(Object paramObject) throws DataAccessException;

	public abstract void update(Object paramObject) throws DataAccessException;

	public abstract void delete(Class paramClass, Serializable paramSerializable)
			throws DataAccessException;

	public abstract Object get(Class paramClass, Serializable paramSerializable);

	public abstract List findByCriteria(DetachedCriteria paramDetachedCriteria);

	public abstract List findByExample(Object paramObject);
}
