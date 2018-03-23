package com.niit.DAO;

import java.util.List;

import com.niit.Model.User;




public interface UserDAO {
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public User getUser(int userId);
	public List<User> listUser(String email);


}
