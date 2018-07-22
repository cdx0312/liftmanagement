package com.hjh.lm.dao;

import com.hjh.lm.domain.LiftInfo;
import com.hjh.lm.domain.LiftRunningDataInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

/**
 * 电梯信息Repo
 */
public interface LiftRunningDataInfoRepository extends JpaRepository<LiftRunningDataInfo, Long>, JpaSpecificationExecutor<LiftInfo> {
}
