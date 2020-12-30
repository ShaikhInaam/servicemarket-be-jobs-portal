package com.jobs.portal.jobsportal.repository;

import com.jobs.portal.jobsportal.entity.JobTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository extends JpaRepository<JobTypeEntity, Integer> {
}
