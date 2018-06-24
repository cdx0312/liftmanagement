package com.hjh.lm.dao;

import com.hjh.lm.domain.AlertEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 报警事件Repo
 */
public interface AlertEventRepository extends JpaRepository<AlertEvent, Long>, JpaSpecificationExecutor<AlertEvent> {
}
