package com.jobs.portal.jobsportal.service.impl;

import com.jobs.portal.jobsportal.entity.JobEntity;
import com.jobs.portal.jobsportal.entity.JobShiftEntity;
import com.jobs.portal.jobsportal.repository.JobRepository;
import com.jobs.portal.jobsportal.repository.JobShiftRepository;
import com.jobs.portal.jobsportal.request.JobPostRequest;
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
        JobEntity jobPost = new JobEntity();
        jobPost.setUsername(jobPostRequest.getUsername());
        jobPost.setTitle(jobPostRequest.getTitle());
        jobPost.setDescription(jobPostRequest.getDescription());
        jobPost.setCountry(jobPostRequest.getCountry());
        jobPost.setCity(jobPostRequest.getCity());
        jobPost.setCompanyName(jobPostRequest.getCompanyName());
        jobPost.setCompanyAddress(jobPostRequest.getCompanyAddress());
        jobPost.setExperienceStart(jobPostRequest.getExperienceStart());
        jobPost.setExperienceEnd(jobPostRequest.getExperienceEnd());
        jobPost.setSalaryStart(jobPostRequest.getSalaryStart());
        jobPost.setSalaryEnd(jobPostRequest.getSalaryEnd());
        jobPost.setQualification(jobPostRequest.getQualification());
        jobPost.setTotalVacancies(jobPostRequest.getTotalVacancies());
        jobPost.setPostedOn(jobPostRequest.getPostedOn());
        jobPost.setJobTypeId(jobPostRequest.getJobTypeId());
        jobPost.setJobShiftId(jobPostRequest.getJobShiftId());
        jobPost.setJobCategory(jobPostRequest.getJobCategory());

        jobPost = jobRepository.saveAndFlush(jobPost);

        return jobPost.getId();
    }
}
