package com.niit.DAOImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.ProfileUpdateDAO;
import com.niit.Model.ProfilePicture;

@Repository("profilePictureDAO")
@Transactional
public class ProfileDAOImpl implements ProfileUpdateDAO  {
	 @Autowired
	    SessionFactory sessionFactory;

	public void save(ProfilePicture profilePicture) 
	{
		
		Session session=sessionFactory.openSession();
        session.save(profilePicture);
        session.flush();
        session.close();
		
	}

	public ProfilePicture getProfilePicture(String loginName) 
	{
		Session session=sessionFactory.getCurrentSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, loginName);
		return profilePicture;
		
	}

}
