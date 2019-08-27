package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.EqualsAndHashCode;

@MappedSuperclass
@EqualsAndHashCode(callSuper=false)
public class BaseModel {
	

	public BaseModel() {
		// TODO Auto-generated constructor stub
	}
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 protected Long id;
	 
	 @Version
	 private Integer version;
	
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

}
