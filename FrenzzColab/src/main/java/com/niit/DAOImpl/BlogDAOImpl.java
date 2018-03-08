package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.BlogDAO;
import com.niit.Model.Blog;
@Repository("BlogDAO")
public class BlogDAOImpl implements BlogDAO{

	@Autowired
    SessionFactory sessionFactory;
	/*@Autowired
	/*public BlogDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}*/
	
	
	public BlogDAOImpl() {
		// TODO Auto-generated constructor stub
	}


	@Transactional
	public boolean addBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
    @Transactional
	public boolean deleteBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
@Transactional
	public boolean updateBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	public Blog getBlog(int blogId) {
		try
		{
			Session session=sessionFactory.openSession();
			Blog blog=session.get(Blog.class,blogId);
			session.close();
			return blog;
		}
		catch(Exception e)
		{
			return null;
		}
	}
@Transactional
	public boolean approveBlog(Blog blog) {
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
 @Transactional
	public boolean rejectBlog(Blog blog) {
		try
		{
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
public List<Blog> listBlog(String username) {
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Blog where username=:username");
	query.setParameter("username",username);
	query.list();
	List<Blog> blog=query.list();
	return blog;
}

}
