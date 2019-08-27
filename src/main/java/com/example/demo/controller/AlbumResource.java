package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.NoValueSpecifiedException;
import com.example.demo.model.Album;
import com.example.demo.model.Photo;
import com.example.demo.service.AbstractDataService;
import com.example.demo.service.RestDataService;


@RestController
@RequestMapping("/album")
public class AlbumResource extends AbstractResource<Album> {
    
	@Autowired
	@Qualifier("photo")AbstractDataService photoService;
	
	
	public AlbumResource(@Qualifier("album") RestDataService<Album> service) {
		super(service);
	}
	
	 @RequestMapping(value= {"/userAlbums"},method = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.TRACE,RequestMethod.HEAD,
			  RequestMethod.DELETE,
			  RequestMethod.PATCH,
			  RequestMethod.OPTIONS},produces = {"application/json"})
	 
	public Set<Album> getAll() {
		 //return super.getAll();
		 throw new NoValueSpecifiedException("Id was not specified.getAll/ mapping is not supported by functional requirements!"); 
	}
	
	 @RequestMapping(value="/userAlbums/{id}",method = RequestMethod.PUT,produces = {"application/json"})
		public Set<Album> getById(@PathVariable("id") Integer id) {
		 return super.getEntityById(id,"userId");		
	}
	
	 
	 @RequestMapping(value="/userAlbums/{propertyName}/{propertyValue}",method = RequestMethod.GET,produces = {"application/json"})
		public Set<Album> getByProperty(@PathVariable("propertyName") String propertyName,
				@PathVariable("propertyValue") String propertyValue) {
			return super.getEntityByProperty(propertyName, propertyValue) ;
					
		}
	 
	  @RequestMapping(value="/userAlbumsWithDetails/{id}",method = RequestMethod.PUT,produces = {"application/json"})
	    public Set<Album> getUserAlbumsWithDetails(@PathVariable("id") Integer userId )
	  {
		  
			Set<Album> albums= super.getEntityById(userId,"userId");
			
			for(Album album:albums)
			{
	          Set<Photo> photos=photoService.getByProperty(album.getId(), "albumId");
			  album.setPhotos(photos);
			}
		   return albums;
	}
	  
	  //no-op
	  @RequestMapping(value="/userAlbumsWithDetails/",
			  method = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.TRACE,RequestMethod.HEAD,
				  RequestMethod.DELETE,
				  RequestMethod.PATCH,
				  RequestMethod.OPTIONS},produces = {"application/json"})
	    public Set<Album> getUserAlbumsWithDetailsWithNoParam()
	  {
		  throw new NoValueSpecifiedException("No parameter was specified! getAll/ mapping is not permitted!");
	}


}
