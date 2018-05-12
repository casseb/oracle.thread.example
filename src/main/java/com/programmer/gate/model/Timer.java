package com.programmer.gate.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Timer {
	
	@Id
	private String id;
	
	@Column(name = "isolation")
	private String isolation;
	
	@Column(name = "vrau")
	private int vrau;
	
	@Column(name = "duration")
	private Long duration;
	
	public Timer(String id, String isolation, int vrau, Long duration) {
		super();
		this.id = id;
		this.isolation = isolation;
		this.vrau = vrau;
		this.duration = duration;
	}

	public Timer() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsolation() {
		return isolation;
	}

	public void setIsolation(String isolation) {
		this.isolation = isolation;
	}

	public int getThread() {
		return vrau;
	}

	public void setThread(int thread) {
		this.vrau = thread;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}
	
	
	
}
