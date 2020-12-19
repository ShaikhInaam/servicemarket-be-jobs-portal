package com.jobs.portal.jobsportal.business.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.jobs.portal.jobsportal.business.base.CountryBusiness;
import com.jobs.portal.jobsportal.dto.CountryListJsonResponse;
import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;
import com.jobs.portal.jobsportal.util.ConfigurationUtil;
import com.jobs.portal.jobsportal.util.Constants;
import com.jobs.portal.jobsportal.util.RestServiceUtility;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


@Service
public class CountryBusinessImpl implements CountryBusiness {

    @Autowired
    ConfigurationUtil configurationUtil;

    @Autowired
    RestServiceUtility utility;


    ArrayList<String> listOfCountries = new ArrayList<String>();

    @Override
    public BaseResponse getJobShift(BaseRequest request) throws Exception {


        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders header = new HttpHeaders();
        header.add("ContentType", "application/json");


        LinkedHashMap response = (LinkedHashMap) utility.callGetJson("https://restcountries.eu/rest/v2/all", CountryListJsonResponse.class, header);
       List<CountryListJsonResponse> jsonResponseList = null;
        if(response !=null){

            jsonResponseList = mapper.convertValue(response, new TypeReference<List<CountryListJsonResponse>>(){});
            for(int i =0; i<jsonResponseList.size(); i++){

                listOfCountries.add(jsonResponseList.get(i).getName());
            }

            return  BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                    .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(listOfCountries).build();

        }else{

            return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                    .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(null).build();
        }



    }
}


