package com.jobs.portal.jobsportal.service.base;
import com.jobs.portal.jobsportal.entity.AppliedJobEntity;
import com.jobs.portal.jobsportal.entity.JobEntity;
import com.jobs.portal.jobsportal.entity.JobShiftEntity;
import com.jobs.portal.jobsportal.entity.JobTypeEntity;
import com.jobs.portal.jobsportal.request.JobApplyRequest;
import com.jobs.portal.jobsportal.request.JobPostRequest;
import java.util.List;


public interface JobService {

    List<JobShiftEntity>getJobShift();
    List<JobTypeEntity> getJobType();
    Integer postJob(JobPostRequest jobPostRequest);
    JobTypeEntity getJobType(Integer id);
    JobShiftEntity getJobShift(Integer id);
    List<JobEntity> getAllJobs();
    List<AppliedJobEntity> getAppliedJobDetails(Integer jobId);
    Integer applyJob(JobApplyRequest request);
    JobEntity getJob(Integer id);

}
