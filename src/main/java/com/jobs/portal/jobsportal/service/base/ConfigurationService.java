package com.jobs.portal.jobsportal.service.base;



import com.jobs.portal.jobsportal.entity.ConfigurationEntity;

import java.util.Map;


public interface ConfigurationService {
    Map updateConstants();
    ConfigurationEntity findConstantsByCode(String code);
}
