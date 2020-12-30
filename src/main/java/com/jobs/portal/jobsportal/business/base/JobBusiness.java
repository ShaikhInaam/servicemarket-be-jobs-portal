package com.jobs.portal.jobsportal.business.base;

import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.request.JobPostRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;

public interface JobBusiness {

    BaseResponse getJobType(BaseRequest baseRequest);
    BaseResponse getJobShift(BaseRequest baseRequest);
    BaseResponse postJob(JobPostRequest jobPostRequest);
}
