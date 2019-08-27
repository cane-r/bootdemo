package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.annotation.DatabaseProfile;
import com.example.demo.annotation.RestProfile;
import com.example.demo.configuration.RestProfileApplicationProperties;
import com.example.demo.exception.NoValueSpecifiedException;
import com.example.demo.model.Album;
import com.example.demo.model.Photo;
import com.example.demo.model.User;

@RestProfile
public abstract class RestDataService<T> extends AbstractDataService<T>  {
	
   protected final RestTemplate template;
   
   protected final RestProfileApplicationProperties props;
   
   protected String url;
	
	public RestDataService(RestTemplate template, RestProfileApplicationProperties props,Class<T> clazz) {
	super();
	this.template = template;
	this.props = props;
	this.clazz=clazz;
	
	if(clazz.equals(User.class)) {
		url=props.getUsersUrl();
	}
	else if(clazz.equals(Album.class)) {
		url=props.getAlbumsUrl();
	}
	else if(clazz.equals(Photo.class)) {
		url=props.getPhotosUrl();
	}
	
}

	@Override
	public Set<T> getAll(){
		return (Set<T>) template.exchange(url, HttpMethod.GET, null,getTypeParameter()).getBody();
			
	}
	@Override
   public Set<T> getByProperty(List<String> listOfPropValues,String name) {
		if(listOfPropValues==null) {
			throw new NoValueSpecifiedException("No value specified for parameter "+name);
		}
		
		Set<T> result=new HashSet<>();
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		
		listOfPropValues.forEach(prop->{
		builder.queryParam(name, prop);
		Set<T> resultList=(Set<T>) template.exchange(builder.toUriString(), HttpMethod.GET, null,getTypeParameter()).getBody();
		result.addAll(resultList);
		});
		
		return result;
				
		/* or fetch all then filter
		List<User> userList=getAllUsers();
		List<String> mailList=Arrays.asList(listOfEmails.split(","));
		
		userList=userList.stream().
		  filter(user->mailList.stream().
				  //will not work for unicode strings
		  anyMatch(mail ->(!user.getEmail().equals("") || !(user.getEmail()==null)) && user.getEmail().toLowerCase().contains(mail.toLowerCase()))).
		  collect(Collectors.toList());
		return userList;
		*/
	}
	@Override
	public Set<T> getByProperty(Integer value,String name){
		if(value==null) {
			throw new NoValueSpecifiedException("No value specified for parameter "+name);
		}
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		builder.queryParam(name, value);
		Set<T> result=(Set<T>) template.exchange(builder.toUriString(), HttpMethod.GET, null,getTypeParameter()).getBody();
		return result;
	}
	
	@Override
	public Set<T> getByProperty(String value,String name) {
		if(value==null) {
			throw new NoValueSpecifiedException("No value specified for parameter "+name);
		}
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		builder.queryParam(name, value);
		Set<T> result=(Set<T>) template.exchange(builder.toUriString(), HttpMethod.GET, null,getTypeParameter()).getBody();
		return result;
	}

}
