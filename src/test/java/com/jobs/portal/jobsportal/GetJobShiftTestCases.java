package com.jobs.portal.jobsportal;

import com.jobs.portal.jobsportal.business.impl.JobBusinessImpl;
import com.jobs.portal.jobsportal.entity.JobShiftEntity;
import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;
import com.jobs.portal.jobsportal.response.JobShiftResponse;
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

public class GetJobShiftTestCases {
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
    public void getJobShiftSuccess()
    {
        List<JobShiftEntity> list = new ArrayList<JobShiftEntity>();
        JobShiftEntity shift1 = new JobShiftEntity(1, "Morning");
        JobShiftEntity shift2 = new JobShiftEntity(2, "Evening");
        JobShiftEntity shift3 = new JobShiftEntity(7, "Night");
        JobShiftEntity shift4 = new JobShiftEntity(4, "Mid Night");
        JobShiftEntity shift5 = new JobShiftEntity(5, "Relation Based");
        JobShiftEntity shift6 = new JobShiftEntity(6, "Noon");
        JobShiftEntity shift7 = new JobShiftEntity(7, "Early Morning");

        list.add(shift1);
        list.add(shift2);
        list.add(shift3);
        list.add(shift4);
        list.add(shift5);
        list.add(shift6);
        list.add(shift7);

        when(jobService.getJobShift()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  = new BaseRequest();
        baseRequest.setUsername("");
        baseRequest.setTransactionId("Abcdefghijklmnop");
        BaseResponse response = jobBusinessImpl.getJobShift(baseRequest);

        List<JobShiftResponse> jobShiftResponses = (ArrayList) response.getResponse();
        assertEquals(7, jobShiftResponses.size());


    }

    @Test
    public void getJobShiftCheckEmpty()
    {
        List<JobShiftEntity> list = new ArrayList<JobShiftEntity>();
        JobShiftEntity shift1 = new JobShiftEntity(1, "Morning");
        JobShiftEntity shift2 = new JobShiftEntity(2, "Evening");
        JobShiftEntity shift3 = new JobShiftEntity(7, "Night");
        JobShiftEntity shift4 = new JobShiftEntity(4, "Mid Night");
        JobShiftEntity shift5 = new JobShiftEntity(5, "Relation Based");
        JobShiftEntity shift6 = new JobShiftEntity(6, "Noon");
        JobShiftEntity shift7 = new JobShiftEntity(7, "Early Morning");

        list.add(shift1);
        list.add(shift2);
        list.add(shift3);
        list.add(shift4);
        list.add(shift5);
        list.add(shift6);
        list.add(shift7);

        when(jobService.getJobShift()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  = new BaseRequest();
        baseRequest.setUsername("");
        baseRequest.setTransactionId("Abcdefghijklmnop");
        BaseResponse response = jobBusinessImpl.getJobShift(baseRequest);

        List<JobShiftResponse> jobShiftResponses = (ArrayList) response.getResponse();
        assertEquals(7, jobShiftResponses.size());


    }

    @Test
    public void getJobShiftCheckNull()
    {
        List<JobShiftEntity> list = null;

        when(jobService.getJobShift()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  = new BaseRequest();
        baseRequest.setUsername("");
        baseRequest.setTransactionId("Abcdefghijklmnop");
        BaseResponse response = jobBusinessImpl.getJobShift(baseRequest);

        List<JobShiftResponse> jobShiftResponses = (ArrayList) response.getResponse();
        assertEquals(null, jobShiftResponses);


    }

    @Test
    public void getJobShiftCheckNullRequest()
    {
        List<JobShiftEntity> list = new ArrayList<JobShiftEntity>();
        JobShiftEntity shift1 = new JobShiftEntity(1, "Morning");
        JobShiftEntity shift2 = new JobShiftEntity(2, "Evening");
        JobShiftEntity shift3 = new JobShiftEntity(7, "Night");
        JobShiftEntity shift4 = new JobShiftEntity(4, "Mid Night");
        JobShiftEntity shift5 = new JobShiftEntity(5, "Relation Based");
        JobShiftEntity shift6 = new JobShiftEntity(6, "Noon");
        JobShiftEntity shift7 = new JobShiftEntity(7, "Early Morning");

        list.add(shift1);
        list.add(shift2);
        list.add(shift3);
        list.add(shift4);
        list.add(shift5);
        list.add(shift6);
        list.add(shift7);

        when(jobService.getJobShift()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  = null;
        BaseResponse response = jobBusinessImpl.getJobShift(baseRequest);

        List<JobShiftResponse> jobShiftResponses = (ArrayList) response.getResponse();
        assertEquals(7, jobShiftResponses.size());


    }

    @Test
    public void getJobShiftCheckNullListData()
    {
        when(jobService.getJobShift()).thenReturn(null);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  = new BaseRequest();
        baseRequest.setUsername("");
        baseRequest.setTransactionId("Abcdefghijklmnop");;
        BaseResponse response = jobBusinessImpl.getJobShift(baseRequest);

        List<JobShiftResponse> jobShiftResponses = (ArrayList) response.getResponse();
        assertEquals(null, jobShiftResponses);



    }

    @Test
    public void getJobShiftCheckNullRequestUsername()
    {
        List<JobShiftEntity> list = new ArrayList<JobShiftEntity>();
        JobShiftEntity shift1 = new JobShiftEntity(1, "Morning");
        JobShiftEntity shift2 = new JobShiftEntity(2, "Evening");
        JobShiftEntity shift3 = new JobShiftEntity(7, "Night");
        JobShiftEntity shift4 = new JobShiftEntity(4, "Mid Night");
        JobShiftEntity shift5 = new JobShiftEntity(5, "Relation Based");
        JobShiftEntity shift6 = new JobShiftEntity(6, "Noon");
        JobShiftEntity shift7 = new JobShiftEntity(7, "Early Morning");

        list.add(shift1);
        list.add(shift2);
        list.add(shift3);
        list.add(shift4);
        list.add(shift5);
        list.add(shift6);
        list.add(shift7);

        when(jobService.getJobShift()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  =  new BaseRequest();
        baseRequest.setUsername(null);
        baseRequest.setTransactionId("Abcdefghijklmnop");;
        BaseResponse response = jobBusinessImpl.getJobShift(baseRequest);

        List<JobShiftResponse> jobShiftResponses = (ArrayList) response.getResponse();
        assertEquals(7, jobShiftResponses.size());


    }
    @Test
    public void getJobShiftCheckNullRequestTranId()
    {
        List<JobShiftEntity> list = new ArrayList<JobShiftEntity>();
        JobShiftEntity shift1 = new JobShiftEntity(1, "Morning");
        JobShiftEntity shift2 = new JobShiftEntity(2, "Evening");
        JobShiftEntity shift3 = new JobShiftEntity(7, "Night");
        JobShiftEntity shift4 = new JobShiftEntity(4, "Mid Night");
        JobShiftEntity shift5 = new JobShiftEntity(5, "Relation Based");
        JobShiftEntity shift6 = new JobShiftEntity(6, "Noon");
        JobShiftEntity shift7 = new JobShiftEntity(7, "Early Morning");

        list.add(shift1);
        list.add(shift2);
        list.add(shift3);
        list.add(shift4);
        list.add(shift5);
        list.add(shift6);
        list.add(shift7);

        when(jobService.getJobShift()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn("SUCCESS");
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn("FAILED");

        BaseRequest baseRequest  =  new BaseRequest();
        baseRequest.setUsername("");
        baseRequest.setTransactionId(null);;
        BaseResponse response = jobBusinessImpl.getJobShift(baseRequest);

        List<JobShiftResponse> jobShiftResponses = (ArrayList) response.getResponse();
        assertEquals(7, jobShiftResponses.size());


    }

    @Test
    public void getJobShiftCheckNullResponseMessage()
    {
        List<JobShiftEntity> list = new ArrayList<JobShiftEntity>();
        JobShiftEntity shift1 = new JobShiftEntity(1, "Morning");
        JobShiftEntity shift2 = new JobShiftEntity(2, "Evening");
        JobShiftEntity shift3 = new JobShiftEntity(7, "Night");
        JobShiftEntity shift4 = new JobShiftEntity(4, "Mid Night");
        JobShiftEntity shift5 = new JobShiftEntity(5, "Relation Based");
        JobShiftEntity shift6 = new JobShiftEntity(6, "Noon");
        JobShiftEntity shift7 = new JobShiftEntity(7, "Early Morning");

        list.add(shift1);
        list.add(shift2);
        list.add(shift3);
        list.add(shift4);
        list.add(shift5);
        list.add(shift6);
        list.add(shift7);

        when(jobService.getJobShift()).thenReturn(list);

        when(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).thenReturn(null);
        when(configurationUtil.getMessage(Constants.FAILUARE_RESPNSE_CODE)).thenReturn(null);

        BaseRequest baseRequest  =  new BaseRequest();
        baseRequest.setUsername("");
        baseRequest.setTransactionId("Abcdefghijklmnop");;
        BaseResponse response = jobBusinessImpl.getJobShift(baseRequest);

        List<JobShiftResponse> jobShiftResponses = (ArrayList) response.getResponse();
        assertEquals(7, jobShiftResponses.size());


    }
}
