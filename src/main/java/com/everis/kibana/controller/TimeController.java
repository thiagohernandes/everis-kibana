package com.everis.kibana.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.kibana.model.Time;
import com.everis.kibana.service.TimeService;

@RestController
@RequestMapping("/api/times")
public class TimeController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TimeService timeService;
	
	@GetMapping("/todos")
    public ResponseEntity<List<Time>> getAllTimes() {
		logger.info("getAllTimes()");
        return ResponseEntity.ok(timeService.getAllTimes());
    }
	
	@GetMapping("/todos-erro")
    public String getAllTimesErro() {
		String response = "";
		try {
			throw new Exception("Exception has occured....");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String stackTrace = sw.toString();
			logger.error("Exception - " + stackTrace);
			response = stackTrace;
		}

		return response;
    }

}
