package com.hjh.lm.dao;

import com.hjh.lm.domain.FixRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 维修记录Repo
 */
public interface FixRecordRepository extends JpaRepository<FixRecord, Long>, JpaSpecificationExecutor<FixRecord> {
    /**
     * 根据电梯编号，查询该电梯的维修记录
     * @param liftId 电梯编号
     * @return 维修记录列表
     */
    List<FixRecord> findAllByLiftId(String liftId);
}
