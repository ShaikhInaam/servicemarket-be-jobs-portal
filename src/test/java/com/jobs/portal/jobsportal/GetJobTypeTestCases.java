package com.jobs.portal.jobsportal;

import com.jobs.portal.jobsportal.business.base.JobBusiness;
import com.jobs.portal.jobsportal.business.impl.JobBusinessImpl;
import com.jobs.portal.jobsportal.entity.JobTypeEntity;
import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;
import com.jobs.portal.jobsportal.response.JobTypeResponse;
import com.jobs.portal.jobsportal.service.base.JobService;
import com.jobs.portal.jobsportal.util.ConfigurationUtil;
import com.jobs.portal.jobsportal.util.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class GetJobTypeTestCases {
    @InjectMocks
    JobBusinessImpl jobBusinessImpl;

    @Mock
    JobService jobService;

    @Mock
    ConfigurationUtil configurationUtil;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getJobTypeSuccess()
    {
        List<JobTypeEntity> list = new ArrayList<JobTypeEntity>();
        JobTypeEntity job1 = new JobTypeEntity(1, "Full time");
        JobTypeEntity job2 = new JobTypeEntity(2, "Part time");
        JobTypeEntity job3 = new JobTypeEntity(2, "Weekend time");

        list.add(job1);
        list.add(job2);
        list.add(job3);

        when(jobService.getJobType()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  = new BaseRequest();
        baseRequest.setUsername("");
        baseRequest.setTransactionId("Abcdefghijklmnop");
        BaseResponse response = jobBusinessImpl.getJobType(baseRequest);

        List<JobTypeResponse> jobTypeResponses = (ArrayList) response.getResponse();
        assertEquals(3, jobTypeResponses.size());


    }

    @Test
    public void getJobTypeCheckEmpty()
    {
        List<JobTypeEntity> list = new ArrayList<JobTypeEntity>();
        JobTypeEntity job1 = new JobTypeEntity(null, "");
        JobTypeEntity job2 = new JobTypeEntity(null, "");
        JobTypeEntity job3 = new JobTypeEntity(null, "");

        list.add(job1);
        list.add(job2);
        list.add(job3);

        when(jobService.getJobType()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  = new BaseRequest();
        baseRequest.setUsername("");
        baseRequest.setTransactionId("Abcdefghijklmnop");
        BaseResponse response = jobBusinessImpl.getJobType(baseRequest);

        List<JobTypeResponse> jobTypeResponses = (ArrayList) response.getResponse();
        assertEquals(3, jobTypeResponses.size());


    }

    @Test
    public void getJobTypeCheckNull()
    {
        List<JobTypeEntity> list = null;

        when(jobService.getJobType()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  = new BaseRequest();
        baseRequest.setUsername("");
        baseRequest.setTransactionId("Abcdefghijklmnop");
        BaseResponse response = jobBusinessImpl.getJobType(baseRequest);

        List<JobTypeResponse> jobTypeResponses = (ArrayList) response.getResponse();
        assertEquals(null, jobTypeResponses);


    }

    @Test
    public void getJobTypeCheckNullRequest()
    {
        List<JobTypeEntity> list = new ArrayList<JobTypeEntity>();
        JobTypeEntity job1 = new JobTypeEntity(1, "Full time");
        JobTypeEntity job2 = new JobTypeEntity(2, "Part time");
        JobTypeEntity job3 = new JobTypeEntity(2, "Weekend time");

        list.add(job1);
        list.add(job2);
        list.add(job3);;

        when(jobService.getJobType()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  = null;
        BaseResponse response = jobBusinessImpl.getJobType(baseRequest);

        List<JobTypeResponse> jobTypeResponses = (ArrayList) response.getResponse();
        assertEquals(3, jobTypeResponses.size());


    }

    @Test
    public void getJobTypeCheckNullListData()
    {
        when(jobService.getJobType()).thenReturn(null);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  = new BaseRequest();
        baseRequest.setUsername("");
        baseRequest.setTransactionId("Abcdefghijklmnop");;
        BaseResponse response = jobBusinessImpl.getJobType(baseRequest);

        List<JobTypeResponse> jobTypeResponses = (ArrayList) response.getResponse();
        assertEquals(null, jobTypeResponses);



    }

    @Test
    public void getJobTypeCheckNullRequestUsername()
    {
        List<JobTypeEntity> list = new ArrayList<JobTypeEntity>();
        JobTypeEntity job1 = new JobTypeEntity(1, "Full time");
        JobTypeEntity job2 = new JobTypeEntity(2, "Part time");
        JobTypeEntity job3 = new JobTypeEntity(2, "Weekend time");

        list.add(job1);
        list.add(job2);
        list.add(job3);;

        when(jobService.getJobType()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  =  new BaseRequest();
        baseRequest.setUsername(null);
        baseRequest.setTransactionId("Abcdefghijklmnop");;
        BaseResponse response = jobBusinessImpl.getJobType(baseRequest);

        List<JobTypeResponse> jobTypeResponses = (ArrayList) response.getResponse();
        assertEquals(3, jobTypeResponses.size());


    }
    @Test
    public void getJobTypeCheckNullRequestTranId()
    {
        List<JobTypeEntity> list = new ArrayList<JobTypeEntity>();
        JobTypeEntity job1 = new JobTypeEntity(1, "Full time");
        JobTypeEntity job2 = new JobTypeEntity(2, "Part time");
        JobTypeEntity job3 = new JobTypeEntity(2, "Weekend time");

        list.add(job1);
        list.add(job2);
        list.add(job3);;

        when(jobService.getJobType()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  =  new BaseRequest();
        baseRequest.setUsername("");
        baseRequest.setTransactionId(null);;
        BaseResponse response = jobBusinessImpl.getJobType(baseRequest);

        List<JobTypeResponse> jobTypeResponses = (ArrayList) response.getResponse();
        assertEquals(3, jobTypeResponses.size());


    }
}
