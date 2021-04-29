package com.jobs.portal.jobsportal.business.impl;

import com.jobs.portal.jobsportal.business.base.CompanyProfileBusiness;
import com.jobs.portal.jobsportal.entity.CompanyProfileEntity;
import com.jobs.portal.jobsportal.repository.CompanyProfileRepository;
import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.request.CompanyProfileRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;
import com.jobs.portal.jobsportal.service.base.CompanyProfileService;
import com.jobs.portal.jobsportal.service.base.JobService;
import com.jobs.portal.jobsportal.util.CommanUtil;
import com.jobs.portal.jobsportal.util.ConfigurationUtil;
import com.jobs.portal.jobsportal.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CompayprofileBusinessImpl implements  CompanyProfileBusiness {

    @Autowired
    CompanyProfileService companyProfileService;
    @Autowired
    ConfigurationUtil configurationUtil;



    @Override
    public BaseResponse AddCompanyProfile(CompanyProfileRequest companyProfileRequest) {
        CompanyProfileEntity companyProfileEntityCompanyName= companyProfileService.getCompanyProfile(companyProfileRequest.getCompanyname());
        if(CommanUtil.isNotNull(companyProfileEntityCompanyName))
        {

            BaseResponse baseResponse = BaseResponse.builder().responseCode(Constants.FAILUARE_RESPNSE_CODE)
                    .responseMessage(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).build();
            return baseResponse;


        }
         companyProfileService.SaveCompanyProfile(companyProfileRequest);

        BaseResponse baseResponse = BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).build();
        return baseResponse;
    }
}
