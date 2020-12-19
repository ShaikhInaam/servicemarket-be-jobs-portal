package com.jobs.portal.jobsportal.service.impl;

import com.jobs.portal.jobsportal.entity.JobEntity;
import com.jobs.portal.jobsportal.entity.JobShiftEntity;
import com.jobs.portal.jobsportal.repository.JobRepository;
import com.jobs.portal.jobsportal.entity.JobTypeEntity;
import com.jobs.portal.jobsportal.repository.JobShiftRepository;
import com.jobs.portal.jobsportal.request.JobPostRequest;
import com.jobs.portal.jobsportal.repository.JobTypeRepository;
import com.jobs.portal.jobsportal.service.base.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobShiftRepository jobShiftRepository;
    @Autowired
    JobTypeRepository jobTypeRepository;

    @Autowired
    JobRepository jobRepository;


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
    public Integer postJob(JobPostRequest jobPostRequest){

        JobEntity jobPost = JobEntity.builder()
                .username(jobPostRequest.getUsername()).title(jobPostRequest.getTitle())
                .description(jobPostRequest.getDescription())
                .country(jobPostRequest.getCountry())
                .city(jobPostRequest.getCity())
                .companyName(jobPostRequest.getCompanyName())
                .companyAddress(jobPostRequest.getCompanyAddress())
                .experienceStart(jobPostRequest.getExperienceStart())
                .experienceEnd(jobPostRequest.getExperienceEnd())
                .salaryStart(jobPostRequest.getSalaryStart())
                .salaryEnd(jobPostRequest.getSalaryEnd())
                .qualification(jobPostRequest.getQualification())
                .totalVacancies(jobPostRequest.getTotalVacancies())
                .postedOn(new Timestamp(System.currentTimeMillis()))
                .jobTypeId(jobPostRequest.getJobTypeId())
                .jobShiftId(jobPostRequest.getJobShiftId())
                .jobCategory(jobPostRequest.getJobCategory()).build();

        jobPost = jobRepository.saveAndFlush(jobPost);

        return jobPost.getId();
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
