package com.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User create(User user) {
		return repository.save(user);
	}
	@Override
	public User update(int userid, User user) {
		User fromData =repository.findById(userid).get();
		
		fromData.setName(user.getName());
		fromData.setPassword(user.getPassword());
		return repository.save(fromData);		
	}
	@Override
	public User getOne(int userid) {
		return repository.findById(userid).get();
		
	}
	@Override
	public List<User> getAll() {
		return repository.findAll();
	}
	@Override
	public void delete(int userid) {
		repository.deleteById(userid);
	}
}
