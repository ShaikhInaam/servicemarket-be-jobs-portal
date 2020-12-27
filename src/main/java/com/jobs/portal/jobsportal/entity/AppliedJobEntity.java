package com.jobs.portal.jobsportal.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "configuration")
public class AppliedJobEntity implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "job_id")
    private Integer jobId;

    private String username;

    @Column(name = "cv_path")
    private String cvPath;

    @Column(name = "cover_letter")
    private String coverLetter;

    private String description;


}
