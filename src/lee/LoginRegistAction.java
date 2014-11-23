package lee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginRegistAction extends ActionSupport{
	
	private String username;
	private String password;
	private String tips;
	private JSONObject obj;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	
	public String execute() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		if(getUsername().equals("scott") && getPassword().equals("tiger")){
			//ctx.getSession().put("username", getUsername());
			ActionContext.getContext().getSession().put("user", getUsername());
			setTips("欢迎, " + getUsername() + ", 您已经登录成功！");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	public String regist() throws Exception{
		ActionContext.getContext().getSession().put("user",getUsername());
		setTips("恭喜您，" + getUsername() + ", 您已经注册成功！");		
		return SUCCESS;	
	}
	
	public String loadTable() throws IOException{
		List<User> ulist = new ArrayList<User>();
		
		User u1 = new User("Antony", "Smith", "8890092", "ASmith@gmail.com");
		ulist.add(u1);
		u1 = new  User("Cindy", "Ford", "3150981", "CFord@sina.com");
		ulist.add(u1);
		u1 = new User("Robert", "Harris", "7782210", "RHarris@163.com");
		ulist.add(u1);
		
		JSONArray jsonarray = JSONArray.fromObject(ulist);
		JSONObject ds = new JSONObject();
		ds.accumulate("total", ulist.size());
		ds.accumulate("rows", jsonarray);

		//HttpServletResponse response = ServletActionContext.getResponse();
		//PrintWriter out =response.getWriter(); 
		//out.print(obj); 
		//System.out.println(obj);
		setObj(ds);
		
		return SUCCESS;
	}
	
	public JSONObject getObj() {
		return obj;
	}
	public void setObj(JSONObject obj) {
		this.obj = obj;
	}
	
}
