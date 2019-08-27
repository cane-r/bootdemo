package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Photo;
import com.example.demo.service.AbstractDataService;

@RestController
@RequestMapping("/photo")
public class PhotoResource extends AbstractResource<Photo>  {

	public PhotoResource(@Qualifier("photo") AbstractDataService<Photo> service) {
		super(service);
	}

}
