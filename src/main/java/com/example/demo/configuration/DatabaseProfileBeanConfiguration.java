package com.example.demo.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.annotation.DatabaseProfile;
import com.example.demo.interceptor.JsonHttpInterceptor;
import com.example.demo.model.RequestDetails;

@DatabaseProfile
@EnableJpaRepositories("com.example.demo.repository")
@EnableTransactionManagement
public class DatabaseProfileBeanConfiguration {
	
	
	@Bean
	public StartupListener listener() {
		return new StartupListener();
	}
	

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

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
	  public RequestDetails requestDetails() {
	      return new RequestDetails();
	}
	

	 private class StartupListener implements ApplicationListener<ContextRefreshedEvent>{

		@Override
		public void onApplicationEvent(ContextRefreshedEvent event) {
			// TODO Auto-generated method stub
			//fill data here 
		}
		 
	 }
}
