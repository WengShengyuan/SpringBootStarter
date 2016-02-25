package org.wsy.core.modules.testtable.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.annotations.Cache;
import org.springframework.stereotype.Service;
import org.wsy.core.modules.testtable.dao.TestTableDao;
import org.wsy.core.modules.testtable.domain.TestTable;

@Service("TestTableServiceImpl")
public class TestTableServiceImpl implements TestTableService{

	@Resource(name="TestTableDaoImpl")
	private TestTableDao testTableDao;
	
	@Transactional
	@Override
	public TestTable save(TestTable entity) throws Exception {
		return testTableDao.save(entity);
	}

	@Transactional
	@Override
	public void delete(TestTable entity) throws Exception {
		testTableDao.delete(entity);		
	}

	@Transactional
	@Override
	public TestTable update(TestTable entity) throws Exception {
		return testTableDao.update(entity);
	}

	@Override
	public List<TestTable> findAll() throws Exception {
		return testTableDao.findAll();
	}

	@Override
	public TestTable findById(Object id) throws Exception {
		return testTableDao.findById(id);
	}

	@Transactional
	@Override
	public void clearTable() throws Exception {
		testTableDao.clearTable();		
	}


}
