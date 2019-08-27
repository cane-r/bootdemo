package com.example.demo.service;

import com.example.demo.annotation.DatabaseProfile;
import com.example.demo.repository.BaseRepository;

@DatabaseProfile
public abstract class AbstractDatabaseDataService<T> extends AbstractDataService<T> {
	
	
	protected BaseRepository repository;

	public AbstractDatabaseDataService(BaseRepository repository) {
		this.repository=repository;
		
	}

}
