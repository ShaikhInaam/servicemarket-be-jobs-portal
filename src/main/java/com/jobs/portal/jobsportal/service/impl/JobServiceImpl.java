package com.jobs.portal.jobsportal.service.impl;

import com.jobs.portal.jobsportal.entity.AppliedJobEntity;
import com.jobs.portal.jobsportal.entity.JobEntity;
import com.jobs.portal.jobsportal.entity.JobShiftEntity;
import com.jobs.portal.jobsportal.repository.AppliedJobRepository;
import com.jobs.portal.jobsportal.repository.JobRepository;
import com.jobs.portal.jobsportal.entity.JobTypeEntity;
import com.jobs.portal.jobsportal.repository.JobShiftRepository;
import com.jobs.portal.jobsportal.request.JobApplyRequest;
import com.jobs.portal.jobsportal.request.JobPostRequest;
import com.jobs.portal.jobsportal.repository.JobTypeRepository;
import com.jobs.portal.jobsportal.response.JobApplyResponse;
import com.jobs.portal.jobsportal.service.base.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobShiftRepository jobShiftRepository;
    @Autowired
    JobTypeRepository jobTypeRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    AppliedJobRepository appliedJobRepository;


    @Override
    public List<JobShiftEntity> getJobShift() {

        List<JobShiftEntity> jobShiftEntities = jobShiftRepository.findAll();
        if(jobShiftEntities != null){
            return jobShiftEntities;
        }
        return null;
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
    public List<JobTypeEntity> getJobType() {

        List<JobTypeEntity> jobTypeEntityList = jobTypeRepository.findAll();
        if(jobTypeEntityList !=null){
            return jobTypeEntityList;
        }
        return null;

    }


    @Override
    public JobTypeEntity getJobType(Integer id){

        return jobTypeRepository.findById(id).orElse(null);
    }

    @Override
    public JobShiftEntity getJobShift(Integer id){

        return  jobShiftRepository.findById(id).orElse(null);
    }

    @Override
    public List<JobEntity> getAllJobs(){

        return jobRepository.findAllByOrderByPostedOnDesc();

    }

    @Override
    public JobEntity getJob(Integer id){

        return  jobRepository.findById(id).orElse(null);

    }

    @Override
    public List<AppliedJobEntity> getAppliedJobDetails(Integer jobId){

        List<AppliedJobEntity> appliedJobEntities = appliedJobRepository.findByJobId(jobId);
        return appliedJobEntities;

    }

    @Override
    public JobApplyResponse applyJob(JobApplyRequest request){

        AppliedJobEntity entity = AppliedJobEntity.builder()
                .username(request.getUsername()).description(request.getDescription())
                .coverLetter(request.getCoverLetter()).jobId(request.getJobId())
                .cvPath(request.getCvPath()).build();

        entity = appliedJobRepository.saveAndFlush(entity);

        Optional<JobEntity> job = jobRepository.findById(request.getJobId());

        if(Objects.nonNull(job) && Objects.nonNull(job.get()))
        {
            JobEntity jobEntity = job.get();
            JobApplyResponse jobApplyResponse = JobApplyResponse.builder().job_title(jobEntity.getTitle())
                    .admin_username(jobEntity.getUsername())
                    .company_name(jobEntity.getCompanyName())
                    .city(jobEntity.getCity()).build();

            return jobApplyResponse;
        }
        else {

            return null;
        }

    }



}
