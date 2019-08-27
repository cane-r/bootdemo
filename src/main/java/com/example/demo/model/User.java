package com.example.demo.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
public class User extends BaseModel {

		private Integer id;
		
		private String name;
		
		private String username;
		
		private String email;
		
		@Embedded
		private Address address;
		
		private String phone;
		
		private String website;
		
		@Embedded
		private Company company;
		
		//private List<Album> albums;
	
		

}
