package com.jobs.portal.jobsportal.response;

import com.jobs.portal.jobsportal.dto.Job;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class JobResponse {


    List<Job> userAppliedJobs = new ArrayList<>();
    List<Job> userPostedJobs = new ArrayList<>();
    List<Job> otherJobs = new ArrayList<>();
}
