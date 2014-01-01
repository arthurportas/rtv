/**
 * 
 */
package com.realtv.dao.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * @author Arthur Portas
 * @date 24/12/2013
 */
public interface IGenericDao<T extends Serializable> {

	public long count();

	public T create(T t);

	public void delete(long id);

	public T find(long id);

	public List<T> getAll();

	public T update(T t);
}
