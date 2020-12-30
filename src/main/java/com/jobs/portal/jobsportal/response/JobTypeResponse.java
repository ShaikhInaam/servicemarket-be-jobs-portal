package com.jobs.portal.jobsportal.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobTypeResponse {

    private Integer id;
    private String name;

}
