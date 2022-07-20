package com.njc.practice.spring.boot.scheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.njc.practice.spring.boot.PracticeSpringBootApplication;
import com.njc.practice.spring.boot.dto.StudentDTO;

@Service
public class NormalSchedulerPrac {

	Logger logger = LoggerFactory.getLogger(PracticeSpringBootApplication.class);

	static final List<StudentDTO> studentList = new ArrayList<>();
	
	

//	@Scheduled(fixedDelayString =  "${spring.scheduler.delay}", initialDelay = 1000)
//	private void runSchedulerPracOne() {
//		logger.info("This is a message from scheduler at time " + LocalDateTime.now());
//	}

//	@Scheduled(cron =  "${spring.scheduler.cron}")
//	private void runSchedulerPracOne() {
//		logger.info("This is a message from scheduler at time " + LocalDateTime.now());
//	}

//	@Scheduled(cron =  "@hourly")
//	private void runSchedulerPracOne() {
//		logger.info("This is a message from scheduler at time " + LocalDateTime.now());
//	}
	@Scheduled(cron =  "1 * * * * *")
	private void runSchedulerPracOne() {
		logger.info("This is a message from scheduler at time " + LocalDateTime.now());
	}
}
