package com.jobs.portal.jobsportal.business.impl;

import com.jobs.portal.jobsportal.business.base.JobBusiness;
import com.jobs.portal.jobsportal.entity.JobTypeEntity;
import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;
import com.jobs.portal.jobsportal.response.JobTypeResponse;
import com.jobs.portal.jobsportal.service.base.JobService;
import com.jobs.portal.jobsportal.util.ConfigurationUtil;
import com.jobs.portal.jobsportal.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobBusinessImpl implements JobBusiness {

    @Autowired
    JobService service;
    @Autowired
    ConfigurationUtil configurationUtil;

    @Override
    public BaseResponse getJobType(BaseRequest baseRequest){

        List<JobTypeEntity> jobTypeEntities = service.getJobType();
        if(jobTypeEntities !=null){

            List<JobTypeResponse> jobTypeResponses = new ArrayList<>();
            for(JobTypeEntity entity : jobTypeEntities){
                jobTypeResponses.add(JobTypeResponse.builder().id(entity.getId()).name(entity.getName()).build());
            }

            return BaseResponse.builder().response(jobTypeResponses).responseCode(Constants.SUCCESS_RESPONSE_CODE).responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).build();

        }else{

            return BaseResponse.builder().response(null).responseCode(Constants.SUCCESS_RESPONSE_CODE).responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).build();
        }
    }


}
