package com.niit.DAO;



import com.niit.Model.ProfilePicture;


public interface ProfileUpdateDAO {
	public void save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String loginName);
}
