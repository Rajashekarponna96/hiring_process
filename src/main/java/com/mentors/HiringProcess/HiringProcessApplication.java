package com.mentors.HiringProcess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@ComponentScan({ "com.mentors.HiringProcess.*" })
//@EnableScheduling
public class HiringProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiringProcessApplication.class, args);
	}

}
