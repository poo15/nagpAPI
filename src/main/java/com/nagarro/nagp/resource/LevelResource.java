package com.nagarro.nagp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.nagarro.nagp.model.Level;
import com.nagarro.nagp.service.LevelService;
@CrossOrigin("*")
@RequestMapping("/admin/level")
@RestController
public class LevelResource {
	
	@Autowired
	private LevelService levelService;
	@GetMapping("")
	public List<Level> getAllLevel(){
		return levelService.getAllLevels();
	}
	
	@GetMapping("/{id}")
	public Level getLevel(@PathVariable("id") String id){
		System.out.println("searched level details "+levelService.getLevel(id));
		return levelService.getLevel(id);
	}
	
	@PostMapping("")
	public ResponseEntity<String> saveUser(@RequestBody Level level){
		String id = levelService.addLevel(level);
		return ResponseEntity.ok().body("level added"+id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> edit(@PathVariable("id") String id, @RequestBody Level level){
		if(levelService.edit(id, level))
			return ResponseEntity.ok().body("Updated level");
		else
			return ResponseEntity.badRequest().body("error");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id){
		if(levelService.delete(id))
		 return ResponseEntity.ok().body("deleted level");
		else
			return ResponseEntity.badRequest().body("error");
	}
	
}
