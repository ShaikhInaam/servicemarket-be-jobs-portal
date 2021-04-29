package com.jobs.portal.jobsportal.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company_profile")


public class CompanyProfileEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column
    private String companyname;
    @Column
    private String address;
    @Column
    private String about;
    @Column
    private String country;
    @Column
    private String city;

}
