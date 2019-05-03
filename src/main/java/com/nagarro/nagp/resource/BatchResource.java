package com.nagarro.nagp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.model.Batch;
import com.nagarro.nagp.service.BatchService;

@CrossOrigin("*")
@RequestMapping("/admin/batch")
@RestController
public class BatchResource {
	
	@Autowired
	private BatchService batchService;
	/**
     * This method handle the get request to find all the batches
     * 
     * @return List of Batches
     */
	@GetMapping("")
	public List<Batch> getAllLevel(){
		return batchService.getAllBatch();
	}
	

	/**
     * This method handle the get request to find a particular batch
     * 
     * @param id, id of the batch
     * 
     */
	@GetMapping("/{id}")
	public Batch getBatch(@PathVariable("id") String id){
		return batchService.getBatch(id);
	}
	
	/**
     * This method handle the post request to adds a batch
     * 
     * @param Batch
     * 
     * @return String, Id of the book
     * 
     */
	@PostMapping("")
	public ResponseEntity<String> saveBatch(@RequestBody Batch batch){
		String id = batchService.addBatch(batch);
		return ResponseEntity.ok().body("batch added"+id);
	}
	
	/**
     * This method handle the Put request edit the batch record
     * @param Batch id, Batch
     * 
     * @return boolean
     */
	@PutMapping("/{id}")
	public ResponseEntity<String> edit(@PathVariable("id") String id, @RequestBody Batch batch){
		if(batchService.edit(id, batch))
			return ResponseEntity.ok().body("Updated batch");
		else
			return ResponseEntity.badRequest().body("Can't update");
	}
	
	

}
