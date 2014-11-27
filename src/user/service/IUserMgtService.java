package user.service;

import java.util.List;

import model.User;

public interface IUserMgtService {

	public List<User> loadUserList();
	
	public void SaveUser(User user);
	
	public User EditUser(int UserID);
	
	public void DeleteUser(int UserID);
}
