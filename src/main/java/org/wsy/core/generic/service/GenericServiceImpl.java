package org.wsy.core.generic.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.wsy.core.generic.dao.GenericDao;

public class GenericServiceImpl<T> implements GenericService<T>{

	@Resource(name = "GenericDaoImpl")
	private GenericDao<T> genericDao;
	
	
	@Transactional
	@Override
	public T save(T entity) throws Exception {
		return genericDao.save(entity);
	}

	@Transactional
	@Override
	public void delete(T entity) throws Exception {
		genericDao.delete(entity);
		
	}

	@Transactional
	@Override
	public T update(T entity) throws Exception {
		return genericDao.update(entity);
	}

	@Override
	public List<T> findAll() throws Exception {
		return genericDao.findAll();
	}

	@Override
	public T findById(Object id) throws Exception {
		return genericDao.findById(id);
	}

	@Transactional
	@Override
	public void clearTable() throws Exception {
		genericDao.clearTable();
	}

}
