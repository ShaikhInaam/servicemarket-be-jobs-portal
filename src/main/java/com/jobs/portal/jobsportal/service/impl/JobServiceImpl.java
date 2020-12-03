package com.jobs.portal.jobsportal.service.impl;

import com.jobs.portal.jobsportal.entity.JobShiftEntity;
import com.jobs.portal.jobsportal.repository.JobShiftRepository;
import com.jobs.portal.jobsportal.service.base.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobShiftRepository jobShiftRepository;


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
}
