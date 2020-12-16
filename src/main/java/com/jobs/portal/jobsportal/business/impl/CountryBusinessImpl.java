package com.jobs.portal.jobsportal.business.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.jobs.portal.jobsportal.business.base.CountryBusiness;
import com.jobs.portal.jobsportal.dto.CountryListJsonResponse;
import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;
import com.jobs.portal.jobsportal.util.ConfigurationUtil;
import com.jobs.portal.jobsportal.util.Constants;
import com.jobs.portal.jobsportal.util.RestServiceUtility;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

@Service
public class CountryBusinessImpl implements CountryBusiness {

    @Autowired
    ConfigurationUtil configurationUtil;

    @Autowired
    RestServiceUtility utility;

    ArrayList<String> ListOfCountries = new ArrayList<String>();

    @Override
    public BaseResponse getJobShift(BaseRequest request) throws Exception {


        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders header = new HttpHeaders();
        header.add("ContentType", "application/json");
     /*   header.add("Authorization", "Basic "+configurationUtil.getMessage(Constants.JOBS_PORTAL_SECRET));

        JobShiftJsonRequest jsonRequest = new JobShiftJsonRequest();
        jsonRequest.setTransactionId(request.getTransactionId());

        LinkedHashMap response = (LinkedHashMap) utility.callPostJson(configurationUtil.getMessage(Constants.JOBS_PORTAL_BASE_URL)+configurationUtil.getMessage(Constants.JOBS_PORTAL_JOB_SHIFT_API), header, jsonRequest, JobShiftJsonResponse.class);
    */


      ArrayList response  = (ArrayList) utility.callGetJson("https://restcountries.eu/rest/v2/all", CountryListJsonResponse.class, header);
          
      System.out.println("rest:: "+response);
        System.out.println(response.size());
        for ( int i = 0 ; i <response.size(); i++){
            LinkedHashMap inner = (LinkedHashMap) response.get(i);
            String country = (String) inner.get("name");
            ListOfCountries.add(country);
        }

      //  System.out.println( "NoC "+ ListOfCountries.size());
        for (int i = 0 ; i<ListOfCountries.size(); i++){
            System.out.println("Country"+ i +": "+ ListOfCountries.get(i));
        }



        CountryListJsonResponse jsonResponse = null;

        if (response != null) {

            jsonResponse = mapper.convertValue(ListOfCountries, new TypeReference<CountryListJsonResponse>() {
            });

            if (jsonResponse.getResponseCode().equals(Constants.SUCCESS_RESPONSE_CODE) &&
                    jsonResponse.getResponseMessage().equalsIgnoreCase(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE))) {

                BaseResponse baseResponse = BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                        .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(jsonResponse.getResponse()).build();
                System.out.println(baseResponse);
                return baseResponse;
            }


        } else {

            BaseResponse baseResponse = BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                    .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(null).build();
            System.out.println(baseResponse);
            return baseResponse;
        }


        return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(null).build();

    }
}


