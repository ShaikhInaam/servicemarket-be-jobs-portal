package com.jobs.portal.jobsportal;

import com.jobs.portal.jobsportal.business.impl.CountryBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.jobs.portal.jobsportal.util.ConfigurationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JobsportalApplication {


    @Autowired
    ConfigurationUtil configurationUtil;

    public static void main(String[] args) {

        SpringApplication.run(JobsportalApplication.class, args);

    }

    @Bean(name = "appRestClient")
    public RestTemplate getRestClient() {
        RestTemplate restClient = new RestTemplate(
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

        // Add one interceptor like in your example, except using anonymous class.
        restClient.setInterceptors(Collections.singletonList((request, body, execution) -> {

            return execution.execute(request, body);
        }));

        return restClient;
    }



    @PostConstruct
    private void init() {
        configurationUtil.updateConstants();
    }
}
