package com.programmer.gate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmer.gate.model.Timer;
import com.programmer.gate.repository.TimerRepository;

@Service("timerService")
public class TimerServiceImpl implements TimerService{

	@Autowired
	private TimerRepository timerRepo;
	
	@Override
	public void save(Timer timer) {
		timerRepo.save(timer);
	}

	@Override
	public Timer query(String id) {
		return timerRepo.findOne(id);
	}

	@Override
	public void deleteAll() {
		timerRepo.deleteAll();
	}

}
