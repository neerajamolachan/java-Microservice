package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;

@Service
public class UserService implements UserServiceImpl {
	
	List<User> list = List.of(
			new User(101L, "Neerja", "22345668"),
			new User(102L, "Amrita", "22322333"),
			new User(103L, "Nitya", "2256665656")
			
			);
	
	
	
	@Override
	public User getUser(Long Id) {
		return this.list.stream().filter(user-> user.getUserId().equals(Id)).findAny().orElse(null);
	}

}
