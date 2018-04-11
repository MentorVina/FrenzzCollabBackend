package com.niit.DAO;

import java.util.List;

import com.niit.Model.Friend;
import com.niit.Model.User;

public interface FriendDAO {
	
	public boolean sendFriendRequest(Friend friend);
	public boolean deleteFriendRequest(int friendId);
	public List<User> showSuggestedFriend(String loginName);
	public List<Friend> showAllFriends(String loginName);
	public List<Friend> showRequestPendingList(String loginName);
	public boolean acceptFriendRequest(int friendId);
	
	
	
	

}
