package com.jobs.portal.jobsportal;

import com.jobs.portal.jobsportal.util.ConfigurationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JobsportalApplication {

    @Autowired
    ConfigurationUtil configurationUtil;

    public static void main(String[] args) {
        SpringApplication.run(JobsportalApplication.class, args);
    }

    @PostConstruct
    private void init() {
        configurationUtil.updateConstants();
    }
}
