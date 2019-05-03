package com.nagarro.nagp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.constants.Constants;
import com.nagarro.nagp.model.Level;
import com.nagarro.nagp.repository.LevelRepository;
import com.nagarro.nagp.service.LevelService;

@Service
public class LevelServiceImpl implements LevelService{
	
	@Autowired
	private LevelRepository levelRepository;
	

	@Override
	public List<Level> getAllLevels() {
		return levelRepository.findAll();
	}


	@Override
	public String addLevel(Level level) {
		if(level.getId() == null || level.getId().equals("")) {
			level.setId(Constants.LEVEL+"_"+levelRepository.findAll().size());
		}
		return levelRepository.save(level).getId();
	}


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


	@Override
	public boolean delete(String id) {
//		if(levelRepository.find(id) != null) {
//			levelRepository.deleteById(id);
//		} else {
//			return false;
//		}
		return true;
	}


	@Override
	public Level getLevel(String id) {
		Level level = levelRepository.find(id);
		if(level != null)
			return level;
		return null;
	}


	@Override
	public Level findIntialLevel() {
		Optional<Level> levels = levelRepository.findLevel(1);
		
		if(levels.isPresent()) {
			return levels.get();
		}
			return null;
	}
}
