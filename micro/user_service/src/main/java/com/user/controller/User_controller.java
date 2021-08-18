package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.User;
import com.user.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class User_controller {
	
	@Autowired
	private RestTemplate temp; // extra e
	
	@Autowired
	private UserServiceImpl userServiceImpl;
		@GetMapping("/{User_id}")
		public User getUser (@PathVariable("User_id")Long userId)
		{	
			User user = this.userServiceImpl.getUser(userId);     //e
			
			List contact =this.temp.getForObject("http://localhost:9002/contact/user/"+ userId,List.class);// instead of both server on and testing   //e
			
			
			//List contact =this.temp.getForObject("http://user_service/contact/user/"+ userId,List.class);//already registerd so we can run like this
			user.setContacts(contact);//e
			return user;//setting contact that is there in list   //e
			
			
			//return this.userServiceImpl.getUser(userId);
		}
	
	
	
	
	
}
