package com.hjh.lm.service;

import com.hjh.lm.domain.LiftInfo;
import com.hjh.lm.vo.LiftInfoVo;

import java.util.List;

/**
 * 报警事件相关的接口
 */
public interface LiftInfoService {
    /**
     * 存储电梯设备信息数据到数据库
     * @param liftInfo 电梯设备信息
     */
    void save(LiftInfo liftInfo);

    /**
     * 根据查询条件来查询电梯设备数据信息
     * @param liftInfoVo 查询条件的封装
     * @return 电梯数据信息列表
     */
    List<LiftInfo> getAllLiftInfos(LiftInfoVo liftInfoVo);

    /**
     * 根据电梯编号删除电梯
     * @param liftId 电梯编号
     * @return 返回删除的电梯的信息
     */
    void removeLiftByLiftId(String liftId);

}
