package com.niit.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.DAO.BlogDAO;
import com.niit.DAO.ForumDAO;
import com.niit.DAO.JobDAO;
import com.niit.DAO.UserDAO;
import com.niit.DAOImpl.BlogDAOImpl;
import com.niit.DAOImpl.ForumDAOImpl;
import com.niit.DAOImpl.JobDAOImpl;
import com.niit.DAOImpl.UserDAOImpl;
import com.niit.Model.ApplyJob;
import com.niit.Model.Blog;
import com.niit.Model.BlogComment;
import com.niit.Model.Forum;
import com.niit.Model.ForumComment;
import com.niit.Model.Job;
import com.niit.Model.User;






@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {
	
	//Data Source Object
		@Bean(name="dataSource")
		public  DataSource getDataSource()
		{  System.out.println("enter in datasource");
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			dataSource.setUsername("hr");
			dataSource.setPassword("hr");
			System.out.println("out of datasource");
			return dataSource;
		
		}
		
		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource datasource)
		{
			System.out.println("enter in session ");
			Properties hibernateProp = new Properties();
			hibernateProp.put("hibernate.hbm2ddl.auto", "update");
			System.out.println("enter in session1 ");
			hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
			System.out.println("enter in session 2");
			
			LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
			System.out.println("enter in session 3");
			sessionFactoryBuilder.addProperties(hibernateProp);
			System.out.println("enter in session 4");
			
			sessionFactoryBuilder.addAnnotatedClass(Blog.class);
			System.out.println("<--------------Blog Class Added-------------->");
			sessionFactoryBuilder.addAnnotatedClass(Forum.class);
			System.out.println("<--------------Forum Class Added-------------->");
			sessionFactoryBuilder.addAnnotatedClass(Job.class);
			System.out.println("<--------------Job Class Added-------------->");
			sessionFactoryBuilder.addAnnotatedClass(User.class);
			System.out.println("<--------------User Class Added-------------->");
			sessionFactoryBuilder.addAnnotatedClass(ApplyJob.class);
			System.out.println("<--------------ApplyJob Class Added-------------->");
			sessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
			System.out.println("<--------------BlogComment Class Added-------------->");
			sessionFactoryBuilder.addAnnotatedClass(ForumComment.class);
			System.out.println("<--------------ForumComment Class Added-------------->");
			
			System.out.println("enter in session 5");
			SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
			System.out.println("out of session ");
			return sessionFactory;
		}
		@Bean(name="blogDAO")
		public BlogDAO getBlogDAOImpl()
		{
			System.out.println("blogDAO found");
			return new BlogDAOImpl();
		}
		
		@Bean(name="forumDAO")
		public ForumDAO getForumDAOImpl()
		{
			System.out.println("ForumDAO found");
			return new ForumDAOImpl();
		}
			
		
		@Bean(name="jobDAO")
		public JobDAO getJobDAOImpl()
		{
			System.out.println("JobDAO found");
			return new JobDAOImpl();
		}
		
		@Bean(name="userDAO")
		public UserDAO getUserDAOImpl()
		{
			System.out.println("UserDAO found");
			return new UserDAOImpl();
		}
	
		
		@Autowired
		@Bean(name="transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			System.out.println("In TrnasaManager");
			return transactionManager;
		}

}
