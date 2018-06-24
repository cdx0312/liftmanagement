package com.hjh.lm.service.Impl;

import com.hjh.lm.dao.LiftInfoRepository;
import com.hjh.lm.domain.AlertEvent;
import com.hjh.lm.domain.LiftInfo;
import com.hjh.lm.domain.MaintainRecord;
import com.hjh.lm.service.LiftInfoService;
import com.hjh.lm.vo.LiftInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class LiftInfoServiceImpl implements LiftInfoService {


    // 使用构造器注入repo
    private LiftInfoRepository liftInfoRepository;

    public LiftInfoServiceImpl(LiftInfoRepository liftInfoRepository) {
        this.liftInfoRepository = liftInfoRepository;
    }

    /**
     * 保存设备记录到数据库
     * @param liftInfo 设备信息实例
     */
    @Override
    public void save(LiftInfo liftInfo) {
        liftInfoRepository.save(liftInfo);
    }

    /**
     * 根据查询条件来查询电梯设备数据信息
     * @param liftInfoVo 查询条件的封装
     * @return 电梯数据信息列表
     */
    @Override
    public List<LiftInfo> getAllLiftInfos(LiftInfoVo liftInfoVo) {
        List<LiftInfo> liftInfos = liftInfoRepository.findAll(new Specification<LiftInfo>() {
            @Override
            public Predicate toPredicate(Root<LiftInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isNoneBlank(liftInfoVo.getLiftId())){
                    list.add(criteriaBuilder.equal(root.get("liftId").as(String.class), liftInfoVo.getLiftId()));
                }
                if (StringUtils.isNoneBlank(liftInfoVo.getLiftAgent())){
                    list.add(criteriaBuilder.equal(root.get("liftAgent").as(String.class), liftInfoVo.getLiftAgent()));
                }
                if (StringUtils.isNoneBlank(liftInfoVo.getLiftEmergencePhoneNumber())){
                    list.add(criteriaBuilder.equal(root.get("liftEmergencePhoneNumber").as(String.class), liftInfoVo.getLiftEmergencePhoneNumber()));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        });
        return liftInfos;
    }

    /**
     * 根据电梯编号删除电梯
     * @param liftId 电梯编号
     * @return 返回删除的电梯的信息
     */
    @Override
    public void removeLiftByLiftId(String liftId) {
        if (StringUtils.isNotBlank(liftId))
            liftInfoRepository.deleteByLiftId(liftId);
    }
}
