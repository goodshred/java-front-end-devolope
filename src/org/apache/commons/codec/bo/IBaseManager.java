package org.apache.commons.codec.bo;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.codec.data.IDataAobject;

public abstract interface IBaseManager<T> {
	public abstract void setDao(IDataAobject paramIDataAobject);

	public abstract Class<T> getEntityClass();

	public abstract String save(Object paramObject);

	public abstract String update(Object paramObject);

	public abstract <T> T findOne(Serializable paramSerializable);

	public abstract String delete(Serializable paramSerializable);

	public abstract List findByAll();

	public abstract List findByProperty(boolean paramBoolean,
			Object[][] paramArrayOfObject);

	public abstract List findByName(String paramString, Object paramObject,
			boolean paramBoolean);
}
