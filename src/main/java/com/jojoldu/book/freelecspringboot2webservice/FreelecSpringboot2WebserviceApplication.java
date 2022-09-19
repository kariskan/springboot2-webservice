package com.jojoldu.book.freelecspringboot2webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //JPA Auditing 기능 활성화
public class FreelecSpringboot2WebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreelecSpringboot2WebserviceApplication.class, args);
	}

}
