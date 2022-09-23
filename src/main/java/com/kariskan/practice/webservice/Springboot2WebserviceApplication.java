package com.kariskan.practice.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaAuditing //JPA Auditing 기능 활성화
@EnableWebSecurity
public class Springboot2WebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2WebserviceApplication.class, args);
	}

}
