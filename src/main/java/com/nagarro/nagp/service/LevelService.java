package com.nagarro.nagp.service;

import java.util.List;

import com.nagarro.nagp.model.Level;

public interface LevelService {
	
	List<Level> getAllLevels();
	
	String addLevel(Level level);
	
	boolean edit(String id, Level level);
	
	boolean delete(String id);
	
	Level getLevel(String id);
	
	Level findIntialLevel();
}
