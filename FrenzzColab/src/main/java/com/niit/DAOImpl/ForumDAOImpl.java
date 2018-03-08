package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.ForumDAO;
import com.niit.Model.Blog;
import com.niit.Model.Forum;
@Repository("ForumDAO")
public class ForumDAOImpl implements ForumDAO {

	@Autowired
    SessionFactory sessionFactory;
	/*@Autowired
	public ForumDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}*/
	@Transactional
	public boolean addForum(Forum forum) {
	
	try
	{
		sessionFactory.getCurrentSession().save(forum);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}

}
	@Transactional
public boolean deleteForum(Forum forum) {
	try
	{
		sessionFactory.getCurrentSession().delete(forum);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	
	
}
	@Transactional
public boolean updateForum(Forum forum) {
	try
	{
		sessionFactory.getCurrentSession().update(forum);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	
	
}

public Forum getForum(int forumId) {
	try
	{
		Session session=sessionFactory.openSession();
		Forum forum=session.get(Forum.class,forumId);
		session.close();
		return forum;
	}
	catch(Exception e)
	{
		return null;
	}

	
}
@Transactional
public boolean approveForum(Forum forum) {
	try
	{
		forum.setStatus("A");
		sessionFactory.getCurrentSession().update(forum);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	
}
@Transactional
public boolean rejectForum(Forum forum) {
	try
	{
		forum.setStatus("NA");
		sessionFactory.getCurrentSession().update(forum);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	
}

public List<Forum> listForum(String username) {
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Forum where username=:username");
	query.setParameter("username",username);
	query.list();
	List<Forum> forum=query.list();
	return forum;
	
}
	
}
