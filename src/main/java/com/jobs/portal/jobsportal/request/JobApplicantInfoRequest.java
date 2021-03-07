package com.jobs.portal.jobsportal.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicantInfoRequest  extends  BaseRequest{

    @NotBlank
    private Integer jobId;

}
