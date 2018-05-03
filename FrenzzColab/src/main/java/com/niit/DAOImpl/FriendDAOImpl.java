package com.niit.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.FriendDAO;
import com.niit.Model.Friend;
import com.niit.Model.User;

@Repository("FriendDAO")
public class FriendDAOImpl implements FriendDAO {
	
	@Autowired
    SessionFactory sessionFactory;

	@Transactional
	public boolean sendFriendRequest(Friend friend) {

           try
           {
        	   friend.setStatus("P");
        	  System.out.println(friend.getStatus());
        	   
        	   sessionFactory.getCurrentSession().save(friend);
        	   return true;
           }
           catch(Exception e)
           {
        	   return false;
           }
	}
	
	@Transactional
	public boolean deleteFriendRequest(int friendId) {
		
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend =(Friend)session.get(Friend.class,friendId);
			
			 sessionFactory.getCurrentSession().delete(friend);
			session.close();
			
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	public List<User> showSuggestedFriend(String loginName) 
	{
		Session session=sessionFactory.openSession();
	
		SQLQuery query=session.createSQLQuery("select  loginName from Users where loginName not in(select friendloginName from Friend where loginName='" +loginName+"')and loginName!='"+loginName+"'");
		List<Object>suggestFriend=(List<Object>)query.list();
		List<User>suggestFriendList=new ArrayList<User>();
		int i=0;
		/*while(i<suggestFriend.size())
		{
			User user=session.get(User.class,(String)suggestFriend);
					suggestFriendList.add(user);
			           i++;
			}*/
		return suggestFriendList;
	}

	public List<Friend> showAllFriends(String loginName) 
	{
		Session session =sessionFactory.openSession();
		Query query=session.createQuery("from Friend where loginName=:currentuser and status='A' ");
		query.setParameter("currentuser", loginName);
		List<Friend> listFriends=query.list();
		return listFriends;
	}

	public List<Friend> showRequestPendingList(String loginName) 
	{
		Session session =sessionFactory.openSession();
		Query query=session.createQuery("from Friend where loginName=:currentuser and status='P' ");
		query.setParameter("currentuser", loginName);
		System.out.println("login name is "+loginName);
		List<Friend> listFriends=query.list();
		return listFriends;
	}
	
	@Transactional
	public boolean acceptFriendRequest(int friendId) 
	{
	 try
	 {
		Session session =sessionFactory.openSession();
		Friend friend =(Friend)session.get(Friend.class,friendId);
		friend.setStatus("A");
		session.close();
		sessionFactory.getCurrentSession().update(friend);
		return true;
	}
	
	 catch(Exception e)
		{
			return false;
		}	
	}
}
