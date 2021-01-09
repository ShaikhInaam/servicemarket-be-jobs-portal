package com.jobs.portal.jobsportal.repository;

import com.jobs.portal.jobsportal.entity.AppliedJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppliedJobRepository extends JpaRepository<AppliedJobEntity, Integer> {


    List<AppliedJobEntity> findByJobId(Integer jobId);


}
