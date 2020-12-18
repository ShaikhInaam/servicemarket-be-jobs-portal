package com.jobs.portal.jobsportal.service.impl;

import com.jobs.portal.jobsportal.entity.JobShiftEntity;
import com.jobs.portal.jobsportal.entity.JobTypeEntity;
import com.jobs.portal.jobsportal.repository.JobShiftRepository;
import com.jobs.portal.jobsportal.repository.JobTypeRepository;
import com.jobs.portal.jobsportal.service.base.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobShiftRepository jobShiftRepository;
    @Autowired
    JobTypeRepository jobTypeRepository;


    @Override
    public List<String> getJobShift() {

        List<String> jobShifts = new ArrayList<>();

        List<JobShiftEntity> jobShiftEntities = jobShiftRepository.findAll();
        if(jobShiftEntities != null){
            for (JobShiftEntity entity:jobShiftEntities) {
                jobShifts.add(entity.getName());
            }
        }

        return jobShifts;
    }

    @Override
    public List<String> getJobType() {
        List<String> jobTypes = new ArrayList<>();
        List<JobTypeEntity> jobTypeEntityList = jobTypeRepository.findAll();
        if(jobTypeEntityList!=null){
            for(JobTypeEntity jobTypeEntity:jobTypeEntityList){
                jobTypes.add(jobTypeEntity.getName());
            }
        }
        return jobTypes;
    }
}
