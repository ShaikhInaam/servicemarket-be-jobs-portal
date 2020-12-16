package com.jobs.portal.jobsportal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CountryListJsonResponse {


    private String[] response;

    private String responseMessage;

    private String responseCode;


}
