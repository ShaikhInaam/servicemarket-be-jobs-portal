package com.jobs.portal.jobsportal.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobApplyResponse {

    private String admin_username;
    private String job_title;
    private String company_name;

}
