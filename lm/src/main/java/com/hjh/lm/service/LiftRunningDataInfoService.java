package com.hjh.lm.service;

import com.hjh.lm.domain.LiftRunningDataInfo;

/**
 * @program: liftmanagement
 * @description: ${description}
 * @author: cdx
 * @create: 2018-07-22 16:36
 **/
public interface LiftRunningDataInfoService {
    /**
     * 存储电梯设备信息数据到数据库
     * @param liftRunningDataInfo 电梯运行数据
     */
    void save(LiftRunningDataInfo liftRunningDataInfo);
}
