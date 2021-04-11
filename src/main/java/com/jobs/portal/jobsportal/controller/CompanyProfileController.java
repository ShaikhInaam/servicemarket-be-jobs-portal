package com.jobs.portal.jobsportal.controller;

import com.jobs.portal.jobsportal.business.base.CompanyProfileBusiness;
import com.jobs.portal.jobsportal.request.CompanyProfileRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyProfileController {
    @Autowired
    CompanyProfileBusiness companyProfileBusiness ;
    @PostMapping("companyprofile")
    public ResponseEntity<BaseResponse> companyProfile(@Valid @RequestBody CompanyProfileRequest request)throws Exception {
     BaseResponse baseResponse =companyProfileBusiness.AddCompanyProfile(request);
        return ResponseEntity.ok(baseResponse);

    }

    }
