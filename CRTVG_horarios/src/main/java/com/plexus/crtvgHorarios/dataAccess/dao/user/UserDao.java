package com.plexus.crtvgHorarios.dataAccess.dao.user;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.plexus.crtvgHorarios.dataAccess.pojo.UserPojo;


public interface UserDao  {
	
	public UserPojo getUser(Long userId);	
	
	public UserPojo getUserByUsername(String username) throws UsernameNotFoundException;	
	
	public UserPojo insertUser(UserPojo userPojo);
	
	public void updateUser(UserPojo userPojo);
	
	public void deleteUserById(Long userId);
	
	public List<UserPojo> getAllUsers();

}
