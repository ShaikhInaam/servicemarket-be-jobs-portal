package com.jobs.portal.jobsportal.repository;

import com.jobs.portal.jobsportal.entity.JobShiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobShiftRepository extends JpaRepository<JobShiftEntity, Integer> {
}
