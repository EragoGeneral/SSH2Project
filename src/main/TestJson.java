package main;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import model.News;

public class TestJson {
	
	public static List<News> buildNewList(){
		
		List<News> newlist = new ArrayList<News>();
		
		News n = new News(1, "T1", "C1");
		newlist.add(n);		
		n = new News(2, "T2", "C2");
		newlist.add(n);		
		n = new News(3, "T3", "C3");
		newlist.add(n);
		
		return newlist;		
	}
	
	public static void main(String[] args) {
		List<News> n = buildNewList();
		JSONArray jsonarray = JSONArray.fromObject(n);
				
		//System.out.println(jsonarray.toString());
		
		
		JSONObject jo = new JSONObject();
		jo.accumulate("total", 28);
		jo.accumulate("rows", jsonarray);
		
		System.out.println(jo);

		List<News> list = (List) JSONArray.toCollection(jsonarray, News.class);  
		for(News tn : list){
			//System.out.println(tn.getTitle() + ", " + tn.getContent());
		}	
		
	}
}
