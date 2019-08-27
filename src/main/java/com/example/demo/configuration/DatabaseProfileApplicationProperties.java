package com.example.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.example.demo.annotation.DatabaseProfile;

import lombok.Getter;

@ConfigurationProperties
@Getter
@DatabaseProfile
public class DatabaseProfileApplicationProperties {

	public DatabaseProfileApplicationProperties() {
		
	}

}
