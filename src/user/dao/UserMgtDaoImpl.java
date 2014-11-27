package user.dao;

import java.util.List;

import model.User;
import common.dao.BaseDaoImpl;

public class UserMgtDaoImpl extends BaseDaoImpl implements IUserMgtDao{

	@Override
	public List<User> loadUserList() {
		List<User> ulist = (List<User>)getList("from User");
		return ulist;
	}

	@Override
	public void SaveUser(User user) {
		save(user);			
	}

	@Override
	public User EditUser(int UserID) {
		User u = (User)get(User.class, UserID);
		
		return u;
	}

	@Override
	public void DeleteUser(int UserID) {
		bulkUpdate("delete from User where id = ?", new Object[]{UserID});
	}

	@Override
	public void UpdateUser(User user) {
		update(user);
	}

}
