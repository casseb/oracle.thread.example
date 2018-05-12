package com.programmer.gate.service;

import com.programmer.gate.model.Timer;

public interface TimerService {

	public void save(Timer timer);
	
	public Timer query(String id);
	
	public void deleteAll();
	
}
