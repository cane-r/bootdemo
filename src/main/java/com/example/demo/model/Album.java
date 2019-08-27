package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Album extends BaseModel {

	private Integer userId;
	
	private User user;
	
	private Integer id;
	
	private String title;
	
	@OneToMany
	private Set<Photo> photos=new HashSet<>();

}
