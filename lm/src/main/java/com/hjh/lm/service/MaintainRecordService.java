package com.hjh.lm.service;

import com.hjh.lm.domain.FixRecord;
import com.hjh.lm.domain.MaintainRecord;
import com.hjh.lm.vo.MaintainRecordVo;

import java.util.List;

/**
 * 报警事件相关的接口
 */
public interface MaintainRecordService {
    /**
     * 存储保养数据到数据库
     * @param maintainRecord 报警事件实例
     */
    void save(MaintainRecord maintainRecord);

    /**
     * 根据电梯编号，查询该电梯的保养记录
     * @param liftId 电梯编号
     * @return 保养记录列表
     */
    List<MaintainRecordVo> getMaintainRecordsByLiftId(String liftId);
}
