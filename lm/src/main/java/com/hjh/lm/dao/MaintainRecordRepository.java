package com.hjh.lm.dao;

import com.hjh.lm.domain.FixRecord;
import com.hjh.lm.domain.MaintainRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 保养记录Repo
 */
public interface MaintainRecordRepository extends JpaRepository<MaintainRecord, Long>, JpaSpecificationExecutor<MaintainRecord> {
    /**
     * 根据电梯编号，查询该电梯的保养记录
     * @param liftId 电梯编号
     * @return 保养记录列表
     */
    List<MaintainRecord> findAllByLiftId(String liftId);
}
