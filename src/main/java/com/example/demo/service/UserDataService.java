package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.configuration.RestProfileApplicationProperties;
import com.example.demo.model.User;

//@EnableConfigurationProperties(RestProfileApplicationProperties.class)
@Qualifier("user")
@Service
public class UserDataService extends RestDataService<User> {
	
	public UserDataService(RestTemplate template, RestProfileApplicationProperties props) {
		super(template, props,User.class);
		
	}

}
