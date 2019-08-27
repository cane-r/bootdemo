package com.example.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.core.ParameterizedTypeReference;

import com.example.demo.model.Album;
import com.example.demo.model.Photo;
import com.example.demo.model.User;

public abstract class AbstractDataService<T> {

	
	protected Class<T> clazz;
	
	public AbstractDataService() {
		// TODO Auto-generated constructor stub
	}
	
	protected ParameterizedTypeReference<?> getTypeParameter() {
		if(clazz.equals(User.class)) {
			return new ParameterizedTypeReference<Set<User>>(){};
		}
		else if(clazz.equals(Album.class)) {
			return new ParameterizedTypeReference<Set<Album>>(){};
		}
		else if(clazz.equals(Photo.class)) {
			return new ParameterizedTypeReference<Set<Photo>>(){};
		}
		return null;
		
	}
	public abstract Set<T> getAll();
	public abstract Set<T> getByProperty(List<String> listOfPropValues,String name);
	public abstract Set<T> getByProperty(Integer value,String name);
	public abstract Set<T> getByProperty(String value,String name);

}
