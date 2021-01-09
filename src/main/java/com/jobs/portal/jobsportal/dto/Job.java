package com.jobs.portal.jobsportal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Job {


    private Integer id;
    private String username;
    private String title;
    private String description;
    private String country;
    private String city;
    private String companyName;
    private String companyAddress;
    private String experienceStart;
    private String experienceEnd;
    private String salaryStart;
    private String salaryEnd;
    private String qualification;
    private String totalVacancies;
    private Timestamp postedOn;
    private String jobType;
    private String jobShift;
    private String jobCategory;


}
