package com.jobs.portal.jobsportal.request;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BaseRequest {

    @NotBlank
    private String transactionId;


}
