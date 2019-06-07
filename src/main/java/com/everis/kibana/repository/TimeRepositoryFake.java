package com.everis.kibana.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.everis.kibana.model.Time;

@Component
public class TimeRepositoryFake {
	
	public final List<Time> fakeTimes = Arrays.asList(new Time("Santos",1912,2),
														     new Time("Flamengo",1912,1),
														     new Time("São Paulo",1930,3),
														     new Time("Internacional",1909,1));
	public List<Time> fakeTimes() {
		return fakeTimes;
	}

}
