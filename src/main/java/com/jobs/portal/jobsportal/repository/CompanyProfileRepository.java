package com.jobs.portal.jobsportal.repository;

import com.jobs.portal.jobsportal.entity.CompanyProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyProfileRepository extends JpaRepository<CompanyProfileEntity , String> {
 CompanyProfileEntity findByCompanyname(String companyName);


}
