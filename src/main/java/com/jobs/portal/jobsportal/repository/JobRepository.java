package com.jobs.portal.jobsportal.repository;

import com.jobs.portal.jobsportal.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<JobEntity, Integer> {


    List<JobEntity> findAllByOrderByPostedOnDesc();
}
