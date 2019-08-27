package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.configuration.RestProfileApplicationProperties;
import com.example.demo.model.Photo;

@Qualifier("photo")
@Service
public class PhotoService extends RestDataService<Photo> {

	
	public PhotoService(RestTemplate template, RestProfileApplicationProperties props) {
		super(template, props,Photo.class);
		// TODO Auto-generated constructor stub
	}

}
