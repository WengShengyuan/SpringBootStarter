package org.wsy.core.modules.testtable.dao;

import org.springframework.stereotype.Repository;
import org.wsy.core.generic.dao.GenericDaoImpl;
import org.wsy.core.modules.testtable.domain.TestTable;

@Repository("TestTableDaoImpl")
public class TestTableDaoImpl extends GenericDaoImpl<TestTable> implements TestTableDao{

}
