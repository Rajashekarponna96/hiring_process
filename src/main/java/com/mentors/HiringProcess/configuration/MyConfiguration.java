package com.mentors.HiringProcess.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mentors.HiringProcess.model.HiringFlowActivity;

@Configuration
public class MyConfiguration {

    @Bean
    public HiringFlowActivity hiringFlowActivity() {
        return new HiringFlowActivity(); // Or instantiate it however appropriate
    }
}
