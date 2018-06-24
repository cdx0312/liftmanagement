package com.hjh.lm.service.Impl;

import com.hjh.lm.dao.AlertEventRepository;
import com.hjh.lm.domain.AlertEvent;
import com.hjh.lm.service.AlertEventService;
import com.hjh.lm.vo.AlertEventVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class AlertEventServiceImpl implements AlertEventService {

    // 使用构造器注入repo
    private final AlertEventRepository alertEventRepository;

    @Autowired
    public AlertEventServiceImpl(AlertEventRepository alertEventRepository) {
        this.alertEventRepository = alertEventRepository;
    }

    /**
     * 根据电梯编号，报警内容，报警状态和处理状态来查询报警记录
     * @param liftId 电梯编号
     * @param alertReason 报警原因
     * @param state 报警状态
     * @param process 处理状态
     * @return 报警事件列表
     */
    public List<AlertEventVo> getAllAlertRecords(String liftId, Integer alertReason, Integer state, Integer process) {
        // 重写dao层的findAll方法，实现多个条件的查找,获取满足条件的alertEvent列表
        List<AlertEvent> alertEventList = alertEventRepository.findAll(new Specification<AlertEvent>() {
            @Override
            public Predicate toPredicate(Root<AlertEvent> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isNoneBlank(liftId)){
                    list.add(criteriaBuilder.equal(root.get("liftId").as(String.class), liftId));
                }
                if (alertReason != null){
                    list.add(criteriaBuilder.equal(root.get("alertReason").as(Integer.class), alertReason));
                }
                if (state != null){
                    list.add(criteriaBuilder.equal(root.get("state").as(Integer.class), state));
                }
                if (process != null){
                    list.add(criteriaBuilder.equal(root.get("process").as(Integer.class), process));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        });

        List<AlertEventVo> alertEventVoList = new ArrayList<>();
        // 将数据从alertEventList中复制到alertEventListVo中去
        for (AlertEvent alertEvent : alertEventList) {
            AlertEventVo alertEventVo = new AlertEventVo();
            alertEventVo.setId(alertEvent.getId());
            alertEventVo.setProcessor(alertEvent.getProcessor());
            alertEventVo.setStartTime(alertEvent.getStartTime());
            alertEventVo.setEndTime(alertEvent.getEndTime());
            alertEventVo.setLiftId(alertEvent.getLiftId());
            // 报警原因 ：1--轿厢报警按钮，2--非平层停梯，3--轿厢困人，4--轿厢冲顶，5--轿厢蹲底，6--开门走梯，7--安全回路故障，8--其他
            if (alertEvent.getAlertReason() != null) {
                switch (alertEvent.getAlertReason()) {
                    case 1:
                        alertEventVo.setAlertReason("轿厢报警按钮");
                        break;
                    case 2:
                        alertEventVo.setAlertReason("飞平层停梯");
                        break;
                    case 3:
                        alertEventVo.setAlertReason("轿厢困人");
                        break;
                    case 4:
                        alertEventVo.setAlertReason("轿厢冲顶");
                        break;
                    case 5:
                        alertEventVo.setAlertReason("轿厢蹲底");
                        break;
                    case 6:
                        alertEventVo.setAlertReason("开门走梯");
                        break;
                    case 7:
                        alertEventVo.setAlertReason("安全回路故障");
                        break;
                    default:
                        alertEventVo.setAlertReason("其他");
                        break;
                }
            } else {
                alertEventVo.setAlertReason("其他");
            }
            // 报警事件状态 1--正在发生，2--已取消，3--误报警
            if (alertEvent.getAlertState() != null) {
                switch (alertEvent.getAlertState()) {
                    case 1:
                        alertEventVo.setAlertState("正在发生");
                        break;
                    case 2:
                        alertEventVo.setAlertState("已取消");
                        break;
                    case 3:
                        alertEventVo.setAlertState("误报警");
                        break;
                    default:
                        alertEventVo.setAlertState("unknown state!");
                        break;
                }
            } else {
                alertEventVo.setAlertState("unknown state!");
            }

            // 报警事件处理进程 1--未处理，2--已处理，3--处理中
            if (alertEvent.getProcess() != null) {
                switch (alertEvent.getProcess()) {
                    case 1:
                        alertEventVo.setProcess("未处理");
                        break;
                    case 2:
                        alertEventVo.setProcess("已处理");
                        break;
                    case 3:
                        alertEventVo.setProcess("处理中");
                        break;
                    default:
                        alertEventVo.setProcess("unknown state!");
                        break;
                }
            } else {
                alertEventVo.setProcess("unknown state!");
            }

            alertEventVoList.add(alertEventVo);
        }

        return alertEventVoList;
    }

    /**
     * 存储alertEvent到数据库中
     * @param alertEvent 报警事件实例
     */
    @Override
    public void save(AlertEvent alertEvent) {
        alertEventRepository.save(alertEvent);
    }


}
