package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.example.demo.annotation.RestProfile;

import lombok.Getter;

//main app properties

@ConfigurationProperties
@Getter
@RestProfile
public class RestProfileApplicationProperties {
	
	
	@Value("${users-resource}")
	private String usersUrl;
	
	@Value("${albums-resource}")
	private String albumsUrl;
	
	@Value("${photos-resource}")
	private String photosUrl;
	
}
