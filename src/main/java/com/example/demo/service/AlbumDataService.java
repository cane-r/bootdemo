package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.configuration.RestProfileApplicationProperties;
import com.example.demo.model.Album;

@Qualifier("album")
@Service
public class AlbumDataService extends RestDataService<Album> {

	
	public AlbumDataService(RestTemplate template, RestProfileApplicationProperties props) {
		super(template, props,Album.class);
		// TODO Auto-generated constructor stub
	}

}
