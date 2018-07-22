package com.hjh.lm.service.Impl;

import com.hjh.lm.LmApplication;
import com.hjh.lm.domain.AlertEvent;
import com.hjh.lm.domain.LiftRunningDataInfo;
import com.hjh.lm.service.LiftRunningDataInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @program: liftmanagement
 * @description: ${description}
 * @author: cdx
 * @create: 2018-07-22 16:44
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LmApplication.class)
public class LiftRunningDataInfoServiceImplTest {

    @Autowired
    private LiftRunningDataInfoService liftRunningDataInfoService;


    @Test
    public void save() {
        LiftRunningDataInfo liftRunningDataInfo = new LiftRunningDataInfo();
        liftRunningDataInfo.setLiftId("djkfa12323");
        liftRunningDataInfo.setDoor(1);
        liftRunningDataInfo.setHeight(123);
        liftRunningDataInfo.setTimestamp(System.currentTimeMillis());
        liftRunningDataInfo.setSpeed(123);
        liftRunningDataInfoService.save(liftRunningDataInfo);
    }
}