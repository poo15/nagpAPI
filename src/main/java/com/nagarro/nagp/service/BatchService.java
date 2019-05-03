package com.nagarro.nagp.service;

import java.util.List;

import com.nagarro.nagp.model.Batch;

public interface BatchService {

	List<Batch> getAllBatch();
	
	String addBatch(Batch batch);
	
	boolean edit(String id, Batch batch);
	
	
	Batch getBatch(String id);
	
}
