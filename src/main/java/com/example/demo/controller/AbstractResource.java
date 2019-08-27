package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.AbstractDataService;

public abstract class AbstractResource<T>  {

	protected AbstractDataService<T> service;
	
	public AbstractResource(AbstractDataService<T> service) {
		this.service=service;
	}
	
	public AbstractDataService<T> getService(){
		return service;
	};

	  public Set<T> getEntityByProperty(@PathVariable("propertyName") String propertyName,
	    		@PathVariable("propertyValue") String propertyValue) {
	    	List<String> propertyList=Arrays.asList(propertyValue.split(","));
	    	if(propertyList.size()>1) {
	    		return service.getByProperty(propertyList,propertyName);
	    	}
	    	else {
	    		return service.getByProperty(propertyValue,propertyName);
	    	}    		
	}
	   
	   
	   public Set<T> getEntityById(@PathVariable("id") Integer id,String name) {
			return service.getByProperty(id,name);
					
		}
	   
	   public Set<T> getAll() {
			return service.getAll();
					
		}
	
}
