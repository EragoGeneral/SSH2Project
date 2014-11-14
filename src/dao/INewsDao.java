package dao;

import java.util.List;

import model.News;

public interface INewsDao {
	public int SaveNews(News news);
	
	public News getNews(Integer id);
	
	public List<News> getList(String hql);
	
	public List<News> findByPage(String hql, int offset, int pageSize);
}
