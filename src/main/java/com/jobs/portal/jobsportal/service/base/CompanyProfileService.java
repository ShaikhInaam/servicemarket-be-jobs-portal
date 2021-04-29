package com.jobs.portal.jobsportal.service.base;

import com.jobs.portal.jobsportal.entity.CompanyProfileEntity;
import com.jobs.portal.jobsportal.request.CompanyProfileRequest;
import org.springframework.stereotype.Service;

@Service
public interface CompanyProfileService {
    CompanyProfileEntity getCompanyProfile (String companyName);
   void SaveCompanyProfile(CompanyProfileRequest companyProfileRequest);

}
