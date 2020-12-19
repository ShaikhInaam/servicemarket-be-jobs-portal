package com.jobs.portal.jobsportal.controller;

import com.jobs.portal.jobsportal.business.impl.CountryBusinessImpl;
import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.request.JobPostRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;
import com.jobs.portal.jobsportal.service.base.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        Integer postJobId = service.postJob(request);
        BaseResponse baseResponse = new BaseResponse();
        if (postJobId != null) {
            baseResponse.setResponseMessage("SUCCESS");
            baseResponse.setResponseCode("00100");
        }else{
            baseResponse.setResponseMessage("something went wrong! we are looking at our end, please try again in sometime");
            baseResponse.setResponseCode("00200");
        }
        return ResponseEntity.ok(baseResponse);

    }

}
