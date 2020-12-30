package com.jobs.portal.jobsportal.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

    private String responseCode;
    private String responseMessage;
    private Object response;




}
