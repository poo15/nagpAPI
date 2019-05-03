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

import com.nagarro.nagp.model.Level;
import com.nagarro.nagp.service.LevelService;


/**
 * @author pooja01
 *
 */
@CrossOrigin("*")
@RequestMapping("/admin/level")
@RestController
public class LevelResource {
	
	@Autowired
	private LevelService levelService;
	
	/**
	 * This method handle get request to get all the levels
	 * 
	 * @return List of levels
	 */
	@GetMapping("")
	public List<Level> getAllLevel(){
		return levelService.getAllLevels();
	}
	
	/**
     * This method handle get request get a particular level
     * 
     * @param Id of the level
     * 
     * @return Level object
     */
	@GetMapping("/{id}")
	public Level getLevel(@PathVariable("id") String id){
		return levelService.getLevel(id);
	}
	
	/**
     * This method handle the post request to adds level
     * 
     * @param Level
     * 
     * @return String , id of the level
     */
	@PostMapping("")
	public ResponseEntity<String> saveLevel(@RequestBody Level level){
		String id = levelService.addLevel(level);
		return ResponseEntity.ok().body("level added"+id);
	}
	
	/**
     * This method handle the put request to edit a level
     * 
     * @param Id of level, Level object
     * 
     * @return boolean
     */
	@PutMapping("/{id}")
	public ResponseEntity<String> edit(@PathVariable("id") String id, @RequestBody Level level){
		if(levelService.edit(id, level))
			return ResponseEntity.ok().body("Updated level");
		else
			return ResponseEntity.badRequest().body("error");
	}
	
	
}
