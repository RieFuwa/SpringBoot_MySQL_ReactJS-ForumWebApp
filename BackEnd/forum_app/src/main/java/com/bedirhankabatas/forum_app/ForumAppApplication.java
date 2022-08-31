package com.bedirhankabatas.forum_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ForumAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumAppApplication.class, args);
	}

}
