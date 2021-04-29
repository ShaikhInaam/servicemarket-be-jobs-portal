package com.jobs.portal.jobsportal.business.base;

import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.request.CompanyProfileRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public interface CompanyProfileBusiness {
    BaseResponse AddCompanyProfile(CompanyProfileRequest companyProfileRequest);
}
