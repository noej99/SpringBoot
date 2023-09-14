package com.noej.aug082ss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Aug082SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Aug082SpringSecurityApplication.class, args);
	}

}
