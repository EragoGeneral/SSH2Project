package service;

import java.util.List;

import model.News;
import dao.INewsDao;
import dao.NewsDaoImpl;

public class ValidServiceImpl implements IValidService {
	
	private INewsDao newdao;
	
	public INewsDao getNewdao() {
		return newdao;
	}

	public void setNewdao(INewsDao newdao) {
		this.newdao = newdao;
	}


	public boolean valid(String name, String pass) {
		if("erago".equals(name) && "123456".equals(pass)){	
			return true;			
		}
		//News n = new News();
		//n.setTitle(name);
		//n.setContent(pass);
		//newdao.SaveNews(n);
		
		News n1 = newdao.getNews(5);
		System.out.println(n1.getTitle());
		System.out.println(n1.getContent());
		
		List<News> l = (List<News>)newdao.findByPage("from News", 0, 4);
		for(News en1 : l){
			System.out.println(en1.getTitle());
			System.out.println(en1.getContent());
		}
		
		List<News> newList = (List<News>)newdao.getList("from News");
		for(News en : newList){
			System.out.println(en.getTitle());
			System.out.println(en.getContent());
		}
		return false;
	}

}
