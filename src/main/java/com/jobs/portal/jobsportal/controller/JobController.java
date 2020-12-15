package com.jobs.portal.jobsportal.controller;

import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.request.JobPostRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;
import com.jobs.portal.jobsportal.service.base.JobService;
import com.jobs.portal.jobsportal.util.ConfigurationUtil;
import com.jobs.portal.jobsportal.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/portal")
public class JobController {

    @Autowired
    JobService service;

    @Autowired
    ConfigurationUtil configurationUtil;


    @PostMapping("/job-shift")
    public ResponseEntity<BaseResponse> login(@Valid @RequestBody BaseRequest request)throws Exception{

        BaseResponse baseResponse = new BaseResponse();

        String value = configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE);
        baseResponse.setResponseCode(Constants.SUCCESS_RESPONSE_CODE);
        baseResponse.setResponseMessage(value);
        baseResponse.setResponse(service.getJobShift());

        return ResponseEntity.ok(baseResponse);

    }


    @PostMapping("/post-job")
    public ResponseEntity<BaseResponse> postJob(@Valid @RequestBody JobPostRequest request)throws Exception{
        Integer isPost = service.postJob(request);
        BaseResponse baseResponse = new BaseResponse();
        if (isPost != null) {
            String value = configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE);
            baseResponse.setResponseCode(Constants.SUCCESS_RESPONSE_CODE);
            baseResponse.setResponseMessage(value);
        }else{
            String value = configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE);
            baseResponse.setResponseCode(Constants.FAILUARE_RESPNSE_CODE);
            baseResponse.setResponseMessage(value);
        }
        return ResponseEntity.ok(baseResponse);

    }

}
