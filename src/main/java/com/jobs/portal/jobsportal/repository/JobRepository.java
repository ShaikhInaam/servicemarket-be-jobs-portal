package com.jobs.portal.jobsportal.repository;

import com.jobs.portal.jobsportal.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<JobEntity, Integer> {


    List<JobEntity> findAllByOrderByPostedOnDesc();
    Optional<JobEntity> findById(Integer id);
}
