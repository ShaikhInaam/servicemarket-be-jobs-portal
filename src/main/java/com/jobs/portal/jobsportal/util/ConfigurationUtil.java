package com.jobs.portal.jobsportal.util;

import com.jobs.portal.jobsportal.service.base.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConfigurationUtil {

    @Autowired
    ConfigurationService configService;


    public static Map<String, String> constants = new HashMap<>();

    public String getMessage(String code){

        if(CommanUtil.isNotNull(constants.get(code))){
            return constants.get(code);

        }else if(CommanUtil.isNotNull(configService.findConstantsByCode(code))){

            constants = configService.updateConstants();
            System.out.println("Updating Constants");
            return configService.findConstantsByCode(code).getMessageEnglish();

        }

        return null;
    }

    public void updateConstants(){

        System.out.println("Updating Constants");
        constants = configService.updateConstants();
    }




}
