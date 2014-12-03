package user.service;

import java.util.List;

import user.dao.IUserMgtDao;


import model.User;

public class UserMgtServiceImpl implements IUserMgtService{

	private IUserMgtDao userDao;
	
	public List<User> loadUserList() {
		
		return userDao.loadUserList();
	}

	public void SaveUser(User user) {
		if(null != new Integer(user.getID()) && user.getID() != 0){
			userDao.UpdateUser(user);
		}else{
			userDao.SaveUser(user);
		}
	}

	public User EditUser(int UserID) {
		User u = (User)userDao.EditUser(UserID);
		return u;
	}

	public void DeleteUser(int UserID) {
		userDao.DeleteUser(UserID);
	}

	public IUserMgtDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserMgtDao userDao) {
		this.userDao = userDao;
	}
	
}
