package com.programmer.gate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.model.Timer;

public interface TimerRepository extends CrudRepository<Timer, String>{
	
	public List<Timer> findByIsolation(String isolation);

}
