package user.controller;

import java.util.List;

import model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import user.service.IUserMgtService;

import com.opensymphony.xwork2.ActionSupport;

public class UserManagementAction extends ActionSupport {

	private IUserMgtService userService;
	private User user;
	private JSONObject jsonObject;
	private int UserID;
	
	public String execute() throws Exception {
		System.out.println("Good");
		return SUCCESS;
	}

	public String LoadUserTable() throws Exception{		
		List<User> userList = userService.loadUserList();		
		JSONArray ja = JSONArray.fromObject(userList);
		if(jsonObject == null){
			jsonObject = new JSONObject();
		}
		jsonObject.accumulate("total", userList.size());
		jsonObject.accumulate("rows", ja);
		
		return SUCCESS;
	}
	
	public String SaveUser() throws Exception{
		userService.SaveUser(user);
		JSONArray ja = JSONArray.fromObject(user);
		if(jsonObject == null){
			jsonObject = new JSONObject();
		}
		//jsonObject.accumulate("errorMsg", "No Success!");
		
		return SUCCESS;
	}
	
	public String EditUser() throws Exception{
		
		return SUCCESS;
	}

	public String DeleteUser() throws Exception{
		//System.out.println(UserID);
		userService.DeleteUser(UserID);
		if(jsonObject == null){
			jsonObject = new JSONObject();
		}
		jsonObject.accumulate("success", true);
		return SUCCESS;
	}
	
	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(IUserMgtService userService) {
		this.userService = userService;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}
}
