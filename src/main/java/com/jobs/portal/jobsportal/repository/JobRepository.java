package com.jobs.portal.jobsportal.repository;

import com.jobs.portal.jobsportal.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, Integer> {
}
