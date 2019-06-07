package com.everis.kibana.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.kibana.model.Time;
import com.everis.kibana.repository.TimeRepositoryFake;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepositoryFake timeRepositoryFake;
	
	public List<Time> getAllTimes() {
		return timeRepositoryFake.fakeTimes();
	}

}
