package com.nagarro.nagp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@GetMapping("")
	public List<Batch> getAllLevel(){
		return batchService.getAllBatch();
	}
	
	@GetMapping("/{id}")
	public Batch getBatch(@PathVariable("id") String id){
		System.out.println("batch to be searched:- "+ id);
		return batchService.getBatch(id);
	}
	
	@PostMapping("")
	public ResponseEntity<String> saveBatch(@RequestBody Batch batch){
		String id = batchService.addBatch(batch);
		return ResponseEntity.ok().body("batch added"+id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> edit(@PathVariable("id") String id, @RequestBody Batch batch){
		System.out.println("Object to update:- "+ batch);
		if(batchService.edit(id, batch))
			return ResponseEntity.ok().body("Updated batch");
		else
			return ResponseEntity.badRequest().body("Can't update");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id){
		if(batchService.delete(id))
		 return ResponseEntity.ok().body("deleted batch");
		else
			return new ResponseEntity<>("Can't delete batch", HttpStatus.NOT_FOUND);
	}

}
