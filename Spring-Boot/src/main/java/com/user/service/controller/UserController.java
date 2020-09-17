package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.User;
import com.user.service.UserService;
@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	//create
	@PostMapping("/create")
	public @ResponseBody User create (@RequestBody User user) {
		return service.create(user);	
	}
	
	//update
	@PutMapping("/update/{userid}")
	public @ResponseBody User update(@PathVariable(value= "userid")int userid,@RequestBody User user) {
		return service.update(userid, user);
	}
	
	//getOne
	@GetMapping("/get/{userid}")
	public @ResponseBody User getone(@PathVariable(value = "userid")int userid) {
	return  service.getOne(userid);
	}
	
	//getAll
	@GetMapping("/get/all")
	public List<User> getall(){
		return service.getAll();
	}
		
	//delete
	@DeleteMapping("/delete/{userid}")
	public void delete(@PathVariable(value = "userid") int userid) {
		service.delete(userid);
	}
}
		