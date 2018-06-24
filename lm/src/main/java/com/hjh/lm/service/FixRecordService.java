package com.hjh.lm.service;

import com.hjh.lm.domain.FixRecord;

import java.util.List;

/**
 * 报警事件相关的接口
 */
public interface FixRecordService {
    /**
     * 存储Maintain到数据库
     * @param fixRecord 报警事件实例
     */
    void save(FixRecord fixRecord);

    /**
     * 根据电梯编号，查询该电梯的维修记录
     * @param liftId 电梯编号
     * @return 维修记录列表
     */
    List<FixRecord> getFixRecordsByLiftId(String liftId);
}
