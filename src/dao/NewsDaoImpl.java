package dao;

import java.util.List;

import model.News;

import common.dao.IBaseDao;

public class NewsDaoImpl implements INewsDao{

	public IBaseDao dao;
	
	@Override
	public int SaveNews(News news) {		
		return dao.save(news);
	}
	
	public News getNews(Integer id){
		return (News)dao.get(News.class, id);
	}
		
	@Override
	public List<News> getList(String hql) {
		return (List<News>)dao.getList(hql);
	}
	
	public List<News> findByPage(String hql, int offset, int pageSize){		
		return (List<News>)dao.findByPage(hql, offset, pageSize);
	}
	
	public IBaseDao getDao() {
		return dao;
	}

	public void setDao(IBaseDao dao) {
		this.dao = dao;
	}
}

	
