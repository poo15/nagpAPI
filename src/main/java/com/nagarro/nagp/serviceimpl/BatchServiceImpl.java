package com.nagarro.nagp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.constants.Constants;
import com.nagarro.nagp.model.Batch;
import com.nagarro.nagp.repository.BatchRepository;
import com.nagarro.nagp.service.BatchService;
/**
 * @author pooja01
 *
 */
@Service
public class BatchServiceImpl implements BatchService{
	@Autowired BatchRepository batchRepository;

	
	/**
     * This method find all the batches
     * 
     * @return List of Batches
     * 
     */
	@Override
	public List<Batch> getAllBatch() {
		
		return batchRepository.findAll();
	}

	/**
     * This method adds a batch
     * 
     * @param Batch
     * 
     * @return String, Id of the book
     * 
     */
	@Override
	public String addBatch(Batch batch) {
		if(batch.getId() == null || batch.getId().equals(""))
		{
			batch.setId(generateBatchId(batch.getTechnology(), batch.getYear()));
		}
		
		return batchRepository.save(batch).getId();
	}
	
	/**
     * This method used to generate system generated batch id
     * 
     * @param technology, year
     * 
     * @return String, the id of the batch
     * 
     */
	String generateBatchId(String technology, int year){
		return Constants.BATCH + "_"+technology+"_"+year;
	}

	/**
     * This method edit the batch record
     * @param Batch id, Batch
     * 
     * @return boolean
     */
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

	/**
     * This method find a particular batch
     * 
     * @param id, id of the batch
     * 
     */
	@Override
	public Batch getBatch(String id) {
		return batchRepository.find(id);
	}

}
