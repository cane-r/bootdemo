package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.AbstractDataService;

@RestController
@RequestMapping("/user")
public class UserResource extends AbstractResource<User> {
	
	
	
	public UserResource(@Qualifier("user")  AbstractDataService<User> service) {
		super(service);
	}

    //@GetMapping(value="/allUsers",produces = "application/json")
    @RequestMapping(value="/allUsers",method = RequestMethod.GET,produces = {"application/json"})
	public Set<User> getAllUsers() {
		return super.getAll();
				
	}
    
    //find a user by id
    @RequestMapping(value="/allUsers/{id}",method = RequestMethod.GET,produces = {"application/json"})
	public Set<User> getUser(@PathVariable("id") Integer id) {
		return super.getEntityById(id,"id");
				
	}
    
    //^(\\s?[^\\s,]+@[^\\s,]+\\.[^\\s,]+\\s?,)*(\\s?[^\\s,]+@[^\\s,]+\\.[^\\s,]+)$}"
    //find a user by any property(email,username,website .. etc) with multiple params
    //for example /api/user/email/Shanna@melissa.tv or  /api/user/email/Shanna@melissa.tv,Shanna@melissa.tv ... any number or params
    //for example /api/user/username/Karianne or /api/user/username/Karianne,Kamren ... any number or params
    // or api/user/id/1,2,3
    //..
    @RequestMapping(value="/{propertyName}/{propertyValue}",method = RequestMethod.POST,produces = {"application/json"})
    public Set<User> getUserByProperty(@PathVariable("propertyName") String propertyName,
    		@PathVariable("propertyValue") String propertyValue) {
    	return super.getEntityByProperty(propertyName, propertyValue); 		
}

    
  
  
	
}
