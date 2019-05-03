package com.nagarro.nagp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.constants.Constants;
import com.nagarro.nagp.model.Batch;
import com.nagarro.nagp.repository.BatchRepository;
import com.nagarro.nagp.service.BatchService;
@Service
public class BatchServiceImpl implements BatchService{
	@Autowired BatchRepository batchRepository;

	@Override
	public List<Batch> getAllBatch() {
		
		return batchRepository.findAll();
	}

	@Override
	public String addBatch(Batch batch) {
		if(batch.getId() == null || batch.getId().equals(""))
		{
			batch.setId(generateBatchId(batch.getTechnology(), batch.getYear()));
		}
		
		return batchRepository.save(batch).getId();
	}
	
	String generateBatchId(String technology, int year){
		return Constants.BATCH + "_"+technology+"_"+year;
	}

	@Override
	public boolean edit(String id, Batch batch) { 
		if(batchRepository.find(id)!= null) {
			batch.setId(id);
			batchRepository.save(batch);
		} else {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean delete(String id) {
		if(batchRepository.find(id)!= null) {
			batchRepository.delete(id);
		} else {
			return false;
		}
		return true;
	}

	@Override
	public Batch getBatch(String id) {
		return batchRepository.find(id);
	}

}
