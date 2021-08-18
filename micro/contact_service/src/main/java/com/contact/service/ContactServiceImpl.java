package com.contact.service;

import java.util.List;

import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import com.contact.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService{
	
	List<Contact> list = List.of(
			new Contact(1L,"ammu.mail.com","Neerja",101L),
			new Contact(2L,"malu.mail.com","Amrita",102L),
			new Contact(3L,"nith.mail.com","Nitya",103L)
			);
	
	
	
	@Override
	public List<Contact> getContactOfUser(Long userId){
		return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}
	
	
	
	

}
