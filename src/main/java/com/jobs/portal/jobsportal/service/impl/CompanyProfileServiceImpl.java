package com.jobs.portal.jobsportal.service.impl;

import com.jobs.portal.jobsportal.entity.CompanyProfileEntity;
import com.jobs.portal.jobsportal.repository.CompanyProfileRepository;
import com.jobs.portal.jobsportal.request.CompanyProfileRequest;
import com.jobs.portal.jobsportal.service.base.CompanyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyProfileServiceImpl implements CompanyProfileService {
    @Autowired
    CompanyProfileRepository companyProfileRepository;
    @Override
    public CompanyProfileEntity getCompanyProfile(String companyName) {
        CompanyProfileEntity companyProfileEntity = companyProfileRepository.findByCompanyname(companyName);
        if(companyProfileEntity != null){
            return companyProfileEntity;
        }
        return null;
    }


    @Override
    public void SaveCompanyProfile(CompanyProfileRequest companyProfileRequest) {
         CompanyProfileEntity companyProfileEntity =  CompanyProfileEntity.builder().companyname(companyProfileRequest.getCompanyname()).
                address(companyProfileRequest.getAddress()).
                city(companyProfileRequest.getCity()).
                country(companyProfileRequest.getCountry()).build();
        companyProfileRepository.save(companyProfileEntity);

    }
}
