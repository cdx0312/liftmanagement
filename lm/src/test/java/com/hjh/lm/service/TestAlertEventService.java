package com.hjh.lm.service;

import com.hjh.lm.LmApplication;
import com.hjh.lm.domain.AlertEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LmApplication.class)
public class TestAlertEventService {
    @Autowired
    private AlertEventService alertEventService;

    @Test
    public void testAdd() {
        AlertEvent alertEvent = new AlertEvent();
        alertEvent.setAlertReason(1);
        alertEvent.setEndTime(new Date());
        alertEvent.setLiftId("1csds");
        alertEvent.setProcess(1);
        alertEvent.setAlertState(1);
        alertEvent.setStartTime(new Date());
        alertEvent.setProcessor("aaaa");
        alertEventService.save(alertEvent);
    }
}
