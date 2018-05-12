package com.programmer.gate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmer.gate.model.Timer;
import com.programmer.gate.repository.TimerRepository;

@RestController
@CrossOrigin
public class TimerController {
	
	@Autowired
	private TimerRepository timerRepo;
	
	@RequestMapping(value = "/serializable")
	public List<Timer> getSerializable(){
		return timerRepo.findByIsolation("SERIALIZABLE");
	}
	
	@RequestMapping(value = "/readUncommitted")
	public List<Timer> getReadUncommitted(){
		return timerRepo.findByIsolation("READ_UNCOMMITTED");
	}
}
