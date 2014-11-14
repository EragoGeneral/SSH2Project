package lee;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginRegistAction extends ActionSupport{
	
	private String username;
	private String password;
	private String tips;
	
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
			setTips("��ӭ, " + getUsername() + ", ���Ѿ���¼�ɹ���");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	public String regist() throws Exception{
		ActionContext.getContext().getSession().put("user",getUsername());
		setTips("��ϲ����" + getUsername() + ", ���Ѿ�ע��ɹ���");		
		return SUCCESS;	
	}
	
}
