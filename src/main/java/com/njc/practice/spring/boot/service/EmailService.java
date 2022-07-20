package com.njc.practice.spring.boot.service;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njc.practice.spring.boot.dto.EmailRequest;
import com.njc.practice.spring.boot.dto.EmailResponse;
import com.njc.practice.spring.boot.quartz.job.EmailJob;

@Service
public class EmailService {

	@Autowired
	private Scheduler scheduler;

	Logger logger = LoggerFactory.getLogger(EmailService.class);

	public JobDetail buildJobDetail(EmailRequest schedulerEmailRequest) {
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("email", schedulerEmailRequest.getEmail());
		jobDataMap.put("subject", schedulerEmailRequest.getSubject());
		jobDataMap.put("body", schedulerEmailRequest.getBody());
		return JobBuilder.newJob(EmailJob.class).withIdentity(UUID.randomUUID().toString(), "email-jobs")
				.withDescription("Send Email Job").usingJobData(jobDataMap).storeDurably().build();
	}
	public Trigger buildTrigger(JobDetail jobDetail, ZonedDateTime startAt) {
		return TriggerBuilder.newTrigger().forJob(jobDetail).withIdentity(jobDetail.getKey().toString(), "email-trigger")
				.withDescription("Send Email Trigger").startAt(Date.from(startAt.toInstant()))
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
				.build();
	}

	public EmailResponse sendAnEmail(final EmailRequest emailRequest) {
		ZonedDateTime dateTime = ZonedDateTime.of(emailRequest.getDateTime(), emailRequest.getTimeZone());
		JobDetail jobDetail = buildJobDetail(emailRequest);
		Trigger trigger =  buildTrigger(jobDetail, dateTime);
		try {
			scheduler.scheduleJob(jobDetail, trigger);
			EmailResponse emailResponse = new EmailResponse(true, jobDetail.getKey().getName(),
					jobDetail.getKey().getGroup(), "Email Send Successfully");
			return emailResponse;
		} catch (SchedulerException exp) {
			logger.error("Error while Scheduling an email: " + exp.getMessage());
			return new EmailResponse(false, "Error occured while scheduling an Email");
		}
	}
}
