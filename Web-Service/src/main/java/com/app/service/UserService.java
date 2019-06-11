package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.entities.UserDetail;

public class UserService {

	public static Map<Integer, UserDetail> map = new HashMap<>();

	public UserService() {
		map.put(1, new UserDetail(1,"himanshu", "himanshu@123"));
		map.put(2, new UserDetail(2,"admin", "admin@123"));
	}
	
	public List<UserDetail> getAllUsers()throws Exception{
		return new ArrayList<>(map.values());
	}
	
	public UserDetail getUser(Integer id)throws Exception{
		return map.get(id);
	}
	
	public UserDetail addUser(UserDetail user)throws Exception{
		if(user.getId()==null || user.getId()==0){
			user.setId(map.size()+1);
			map.put(user.getId(), user);
			return user;
		}else{
			throw new Exception();
		}
	}
	
	public UserDetail deleteUser(Integer id)throws Exception{
		if(id!=null && id!=0){
			UserDetail user = map.get(id);
			map.remove(id);
			return user;
		}else{
			throw new Exception();
		}
	}
	
	public UserDetail updateUser(Integer id, UserDetail user)throws Exception{
		if(id!=null && id!=0){
			user.setId(id);
			map.put(id, user);
			return user;
		}else{
			throw new Exception();
		}
	}
	
	public UserDetail findUserByName(String name)throws Exception{
		return map.get(1);
	}
	
	public UserDetail findUserByUserName(String userName)throws Exception{
		return map.get(2);
	}
	
	public static Map<Integer, UserDetail> getMap() {
		return map;
	}

	public static void setMap(Map<Integer, UserDetail> map) {
		UserService.map = map;
	}
}
