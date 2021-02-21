package com.xes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class XesAppTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(XesAppTemplateApplication.class, args);
	}

}
