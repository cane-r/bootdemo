package com.example.demo.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.annotation.RestProfile;
import com.example.demo.interceptor.JsonHttpInterceptor;
import com.example.demo.model.RequestDetails;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RestProfile
public class RestProfileBeanConfiguration {
	
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate template=new RestTemplate();
		List<ClientHttpRequestInterceptor> list=new ArrayList<ClientHttpRequestInterceptor>();
		list.add(jsonInterceptor());
		template.setInterceptors(list);
		return template;
	}
	
	@Bean
	public ClientHttpRequestInterceptor jsonInterceptor() {
		return new JsonHttpInterceptor();
	}
	
	/*
	@Bean
	public Jackson2ObjectMapperBuilder jsonConverterConfiguration() {
		Jackson2ObjectMapperBuilder mapper=new Jackson2ObjectMapperBuilder ();
		mapper.failOnUnknownProperties(false);
		mapper.indentOutput(true);
		mapper.failOnEmptyBeans(false);
		return mapper;
	}
	*/

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
	  public RequestDetails requestDetails() {
	      return new RequestDetails();
	}
	
}
