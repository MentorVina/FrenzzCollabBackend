package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Friend {
	@Id
	@GeneratedValue(generator="friend_sequence", strategy= GenerationType.SEQUENCE)
	@SequenceGenerator(name="friend_sequence", sequenceName="friend_seq", initialValue=1, allocationSize=1)
	int friendId;
	String loginName;
	String friendloginName;
	String status;
	
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getFriendloginName() {
		return friendloginName;
	}
	public void setFriendloginName(String friendloginName) {
		this.friendloginName = friendloginName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
