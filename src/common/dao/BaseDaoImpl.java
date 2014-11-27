package common.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl extends HibernateDaoSupport implements IBaseDao {

	@Override
	public Object get(Class cls, Integer id) {
		return getHibernateTemplate().get(cls, id);
	}

	@Override
	public Integer save(Object obj) {
		return (Integer)getHibernateTemplate().save(obj);
	}

	@Override
	public void update(Object obj) {
		getHibernateTemplate().update(obj);		
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(id);		
	}

	@Override
	public void delete(Object obj) {
		getHibernateTemplate().delete(obj);
	}

	public List getList(String hql){
		return getHibernateTemplate().find(hql);
	}
	
	
	
	@Override
	public List findByPage(final String sql, final int offset, final int pageSize) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List result = session.createQuery(sql)
						.setFirstResult(offset)
						.setMaxResults(pageSize)
						.list();
				return result;
			}
			
		});
		
		return list;
	}

	@Override
	public void bulkUpdate(String hql, Object[] values) throws DataAccessException{
		getHibernateTemplate().bulkUpdate(hql, values);		
	}
	
	
}
