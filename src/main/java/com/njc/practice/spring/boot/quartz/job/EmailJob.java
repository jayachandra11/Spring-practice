package com.njc.practice.spring.boot.quartz.job;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class EmailJob extends QuartzJobBean {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MailProperties mailProperties;
	
	Logger logger = LoggerFactory.getLogger(EmailJob.class);

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
			JobDataMap jobDataMap = context.getMergedJobDataMap();
			String subject = jobDataMap.getString("subject");
			String body = jobDataMap.getString("body");
			String toEmail = jobDataMap.getString("email");
			snedEmail(mailProperties.getUsername(), toEmail, subject, body);
	}

	private void snedEmail(String fromEmail, String toEmail, String subject, String body)  {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, StandardCharsets.UTF_8.toString());
		try {
			messageHelper.setFrom(fromEmail);
			messageHelper.setTo(toEmail);
			messageHelper.setSubject(subject);
			messageHelper.setText(body);
			mailSender.send(message);
		} catch (MessagingException e) {
			logger.error(e.getMessage());
		}
		
	}

}
