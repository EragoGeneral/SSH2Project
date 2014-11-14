package lee;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	private String username;
	private String password;
	private String tips;
	
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
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
	
	public String execute() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		Integer counter = (Integer)ctx.getApplication().get("counter");
		
		if(counter == null){
			counter = 1;
		}else{
			counter = counter + 1;
		}
		
		ctx.getApplication().put("counter", counter);
		ctx.getSession().put("user", getUsername());
		
		if(getUsername().equals("scott") && getPassword().equals("tiger")){
			ctx.put("tips", "服务器提示：您已经成功的登录！");
			return "success";
		}else{
			return "error";
		}
	}

}
