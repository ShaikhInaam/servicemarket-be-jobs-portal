package com.jobs.portal.jobsportal.response;

import com.jobs.portal.jobsportal.dto.Job;
import com.jobs.portal.jobsportal.dto.JobApplicants;
import com.jobs.portal.jobsportal.entity.JobEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.xml.transform.sax.SAXResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Builder
public class JobApplicantInfoResponse {

        Optional<JobEntity> jobDetails ;
        List<JobApplicants> applicants;

}
