package com.hjh.lm.service.Impl;

import com.hjh.lm.dao.FixRecordRepository;
import com.hjh.lm.domain.FixRecord;
import com.hjh.lm.domain.MaintainRecord;
import com.hjh.lm.service.FixRecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FixRecordServiceImpl implements FixRecordService {

    // 使用构造器注入repo
    private final FixRecordRepository fixRecordRepository;

    @Autowired
    public FixRecordServiceImpl(FixRecordRepository fixRecordRepository) {
        this.fixRecordRepository = fixRecordRepository;
    }

    /**
     * 保存维修记录到数据库
     * @param fixRecord 维修记录实例
     */
    @Override
    public void save(FixRecord fixRecord) {
        fixRecordRepository.save(fixRecord);
    }

    /**
     * 根据电梯编号，查询该电梯的维修记录
     * @param liftId 电梯编号
     * @return 维修记录列表
     */
    @Override
    public List<FixRecord> getFixRecordsByLiftId(String liftId) {
        if (StringUtils.isNotBlank(liftId))
            return fixRecordRepository.findAllByLiftId(liftId);
        else
            return fixRecordRepository.findAll();
    }
}
