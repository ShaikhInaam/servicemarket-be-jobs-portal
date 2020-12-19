package com.jobs.portal.jobsportal.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job")
public class JobEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String title;
    private String description;
    private String country;
    private String city;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_address")
    private String companyAddress;
    @Column(name = "experience_start")
    private String experienceStart;
    @Column(name = "experience_end")
    private String experienceEnd;
    @Column(name = "salary_start")
    private String salaryStart;
    @Column(name = "salary_end")
    private String salaryEnd;
    private String qualification;
    @Column(name = "total_vacancies")
    private String totalVacancies;
    @Column(name = "posted_on")
    private Timestamp postedOn;
    @Column(name = "job_type_id")
    private Integer jobTypeId;
    @Column(name = "job_shift_id")
    private Integer jobShiftId;
    @Column(name = "job_category")
    private String jobCategory;
}
