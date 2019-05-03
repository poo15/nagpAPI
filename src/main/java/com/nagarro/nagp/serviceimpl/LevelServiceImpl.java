package com.nagarro.nagp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.constants.Constants;
import com.nagarro.nagp.model.Level;
import com.nagarro.nagp.repository.LevelRepository;
import com.nagarro.nagp.service.LevelService;

/**
 * @author pooja01
 *
 */
@Service
public class LevelServiceImpl implements LevelService{
	
	@Autowired
	private LevelRepository levelRepository;
	
	/**
     * This method get all the levels
     * 
     * @return List of levels
     * 
     */
	@Override
	public List<Level> getAllLevels() {
		return levelRepository.findAll();
	}

	/**
     * This method adds level
     * 
     * @param Level
     * 
     * @return String , id of the level
     */
	@Override
	public String addLevel(Level level) {
		if(level.getId() == null || level.getId().equals("")) {
			level.setId(Constants.LEVEL+"_"+levelRepository.findAll().size());
		}
		return levelRepository.save(level).getId();
	}

	/**
     * This method edit a level
     * 
     * @param Id of level, Level object
     * 
     * @return boolean
     */
	@Override
	public boolean edit(String id, Level level) {
		if(levelRepository.find(id) != null) {
			level.setId(id);
			levelRepository.save(level);
		} else {
			return false;
		}
		
		return true;
	}

	/**
     * This method get a particular level
     * 
     * @param Id of the level
     * 
     * @return Level object
     */

	@Override
	public Level getLevel(String id) {
		Level level = levelRepository.find(id);
		if(level != null)
			return level;
		return null;
	}


	/**
     * This method find the initial level
     * 
     * @return Level 
     * 
     */
	@Override
	public Level findIntialLevel() {
		Optional<Level> levels = levelRepository.findLevel(1);
		
		if(levels.isPresent()) {
			return levels.get();
		}
			return null;
	}
}
