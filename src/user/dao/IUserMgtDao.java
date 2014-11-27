package user.dao;

import java.util.List;

import model.User;

public interface IUserMgtDao {

	public List<User> loadUserList();
	
	public void SaveUser(User user);
	
	public void UpdateUser(User user);
	
	public User EditUser(int UserID);
	
	public void DeleteUser(int UserID);
	
}
