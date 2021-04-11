package com.jobs.portal.jobsportal.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CompanyProfileRequest extends  BaseRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String companyname;
    @NotBlank
    private String address;
    @NotBlank
    private String about;
    @NotBlank
    private String country;
    @NotBlank
    private String city;
}
