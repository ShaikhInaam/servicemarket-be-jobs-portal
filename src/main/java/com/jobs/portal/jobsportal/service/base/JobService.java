package com.jobs.portal.jobsportal.service.base;

import com.jobs.portal.jobsportal.request.JobPostRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {

    List<String> getJobShift();
    List<String> getJobType();

    Integer postJob(JobPostRequest jobPostRequest);

}
