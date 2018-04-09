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
import com.niit.Model.BlogComment;
@Repository("BlogDAO")
public class BlogDAOImpl implements BlogDAO{

	@Autowired
    SessionFactory sessionFactory;
	private Object username;
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
	List<Blog> listBlogs=query.list();
	return listBlogs;
}

@Transactional
public boolean incrementLikes(Blog blog) {
	try
	{
		int likes=blog.getLikes();
		likes++;
		blog.setLikes(likes);
		sessionFactory.getCurrentSession().update(blog);
		
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	
}

@Transactional
public boolean addBlogComment(BlogComment blogComment) {
	try
	{
		sessionFactory.getCurrentSession().save(blogComment);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	
}

@Transactional
public boolean deleteBlogComment(BlogComment blogComment) {
	try
	{
		sessionFactory.getCurrentSession().delete(blogComment);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	
}


public BlogComment getBlogComment(int commentId) {
	try
	{
		Session session=sessionFactory.openSession();
		BlogComment blogComment=session.get(BlogComment.class,commentId);
		session.close();
		return blogComment;
	}
	catch(Exception e)
	{
		return null;
	}
	
}


public List<BlogComment> listBlogComment(int blogId) {
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from BlogComment where blogId=:blogId");
	query.setParameter("blogId",blogId);
	List<BlogComment> listBlogComment=query.list();
	return listBlogComment;
}

}
