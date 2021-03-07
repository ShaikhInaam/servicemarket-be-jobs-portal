package com.jobs.portal.jobsportal.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder

public class JobApplicants {

    private String name;
    private String cvPath;
    private String coverLetter;
    private String description;
}
