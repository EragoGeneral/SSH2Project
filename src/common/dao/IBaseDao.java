package common.dao;

import java.util.List;

public interface IBaseDao {
	
	public Object get(Class cls, Integer id);
	
	public Integer save(Object obj);
	
	public void update(Object obj);
	
	public void delete(Integer id);
	
	public void delete(Object obj);		

	public List getList(String hql);
		
	public List findByPage(final String sql, final int offset, final int pageSize);
	
	public void bulkUpdate(String hql, Object[] values);
}
