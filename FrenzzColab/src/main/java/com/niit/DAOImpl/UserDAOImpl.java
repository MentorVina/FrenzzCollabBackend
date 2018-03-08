package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.UserDAO;
import com.niit.Model.Blog;
import com.niit.Model.User;
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
    SessionFactory sessionFactory;
	
	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	@Transactional
	public boolean addUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public User getUser(int userId) {
		try
		{
			Session session=sessionFactory.openSession();
			User user=session.get(User.class,userId);
			session.close();
			return user;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<User> listUser(String email) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where email=:email");
		query.setParameter("email",email);
		query.list();
		List<User> user=query.list();
		return user;
	}
	
	

}
