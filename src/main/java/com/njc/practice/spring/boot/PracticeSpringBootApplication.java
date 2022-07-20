package com.njc.practice.spring.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaAuditing
@EnableSwagger2
@EnableScheduling
public class PracticeSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeSpringBootApplication.class, args);
	}

}
