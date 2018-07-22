package com.hjh.lm.service.Impl;

import com.hjh.lm.dao.LiftInfoRepository;
import com.hjh.lm.dao.LiftRunningDataInfoRepository;
import com.hjh.lm.domain.LiftInfo;
import com.hjh.lm.domain.LiftRunningDataInfo;
import com.hjh.lm.service.LiftInfoService;
import com.hjh.lm.service.LiftRunningDataInfoService;
import com.hjh.lm.vo.LiftInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class LiftRunningDataInfoServiceImpl implements LiftRunningDataInfoService {


    // 使用构造器注入repo
    private LiftRunningDataInfoRepository liftRunningDataInfoRepository;

    public LiftRunningDataInfoServiceImpl(LiftRunningDataInfoRepository liftRunningDataInfoRepository) {
        this.liftRunningDataInfoRepository = liftRunningDataInfoRepository;
    }


    /**
     * 保存设备记录到数据库
     * @param liftRunningDataInfo 设备信息实例
     */
    @Override
    public void save(LiftRunningDataInfo liftRunningDataInfo) {
        liftRunningDataInfoRepository.save(liftRunningDataInfo);
    }
}
