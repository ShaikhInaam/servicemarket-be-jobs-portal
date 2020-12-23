package com.jobs.portal.jobsportal.business.base;

import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;

public interface JobBusiness {

    public BaseResponse getJobType(BaseRequest baseRequest);
}
