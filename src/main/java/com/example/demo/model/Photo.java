package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Photo extends BaseModel {

	
	private Integer albumId;
	@ManyToOne()
	private Album album;
	//private Integer id;
	private String title;
	private String url;
	private String thumbnailUrl;

}
