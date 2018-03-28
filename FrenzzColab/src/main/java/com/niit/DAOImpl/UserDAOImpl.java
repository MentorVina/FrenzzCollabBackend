package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.UserDAO;
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
			System.out.println(e);
			return false;
		}
	}
	@Transactional
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
	@Transactional
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

	public User getUser(String loginName) {
		try
		{
			Session session=sessionFactory.openSession();
			User user=session.get(User.class,loginName);
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
		List<User> listUsers=query.list();
		return listUsers;
	}

	public boolean checkLogin(User user) {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from User where loginName=:loginName and pass=:pass");
			query.setParameter("loginName",user.getLoginName());
			query.setParameter("pass", user.getPass());
			User users=(User)query.list().get(0);
			if(users==null)
				return false;
			else
				return true;
			
	  }
		catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	public boolean updateOnlineStatus(String status, User user) {
		try
		{
			user.setIsOnline(status);
			sessionFactory.getCurrentSession().update(user);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	

}
