package integrity;

import com.opensymphony.xwork2.Action;

import service.IValidService;

public class ValidAction implements Action{
	private String username;
	private String password;
	
	private String tips;
	private IValidService vs;
	
	public String valid() throws Exception{
				
		if(vs.valid(getUsername(), getPassword())){
			setTips("Congratulation! Well Done!"); 			
			return SUCCESS;
		}else{
			setTips("Bad luck! Need more test!");
			return ERROR;
		}
		//System.out.println(getTips());
	}
	
	public String execute() throws Exception{
		return null;		
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
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public void setVs(IValidService vs) {
		this.vs = vs;
	}	
	
}
