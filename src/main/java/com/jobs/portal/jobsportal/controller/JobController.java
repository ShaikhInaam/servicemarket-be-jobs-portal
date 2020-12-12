package com.jobs.portal.jobsportal.controller;

import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.request.JobPostRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;
import com.jobs.portal.jobsportal.service.base.JobService;
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

    @PostMapping("/job-shift")
    public ResponseEntity<BaseResponse> login(@Valid @RequestBody BaseRequest request)throws Exception{

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResponseMessage("SUCCESS");
        baseResponse.setResponseCode("00100");
        baseResponse.setResponse(service.getJobShift());

        return ResponseEntity.ok(baseResponse);

    }


    @PostMapping("/post-job")
    public ResponseEntity<BaseResponse> postJob(@Valid @RequestBody JobPostRequest request)throws Exception{
        Integer isPost = service.postJob(request);
        BaseResponse baseResponse = new BaseResponse();
        if (isPost != null) {
            baseResponse.setResponseMessage("SUCCESS");
            baseResponse.setResponseCode("00100");
        }else{
            baseResponse.setResponseMessage("something went wrong! we are looking at our end, please try again in sometime");
            baseResponse.setResponseCode("00200");
        }
        baseResponse.setResponse(isPost);
        return ResponseEntity.ok(baseResponse);

    }

}
