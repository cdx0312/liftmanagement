package com.hjh.lm.service.Impl;

import com.hjh.lm.dao.FixRecordRepository;
import com.hjh.lm.dao.MaintainRecordRepository;
import com.hjh.lm.domain.FixRecord;
import com.hjh.lm.domain.MaintainRecord;
import com.hjh.lm.service.FixRecordService;
import com.hjh.lm.service.MaintainRecordService;
import com.hjh.lm.vo.MaintainRecordVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MaintainRecordServiceImpl implements MaintainRecordService {

    // 使用构造器注入repo
    private final MaintainRecordRepository maintainRecordRepository;

    @Autowired
    public MaintainRecordServiceImpl(MaintainRecordRepository maintainRecordRepository) {
        this.maintainRecordRepository = maintainRecordRepository;
    }

    /**
     * 保存保养记录到数据库
     * @param maintainRecord 维修记录实例
     */
    @Override
    public void save(MaintainRecord maintainRecord) {
        maintainRecordRepository.save(maintainRecord);
    }

    /**
     * 根据电梯编号，查询该电梯的保养记录
     * @param liftId 电梯编号
     * @return 保养记录列表
     */
    @Override
    public List<MaintainRecordVo> getMaintainRecordsByLiftId(String liftId) {
        // 从数据库中根据liftId，获取保养记录
        List<MaintainRecord> maintainRecordList;
        if (StringUtils.isNotBlank(liftId))
            maintainRecordList = maintainRecordRepository.findAllByLiftId(liftId);
        else
            maintainRecordList = maintainRecordRepository.findAll();
        // 遍历保养记录，将其数据存入Vo中
        List<MaintainRecordVo> maintainRecordVoList = new ArrayList<>();
        for (MaintainRecord maintainRecord : maintainRecordList) {
            MaintainRecordVo maintainRecordVo = new MaintainRecordVo();
            //数据从maintainRecord中转移到maintainRecordVo中
            maintainRecordVo.setLiftId(maintainRecord.getLiftId());
            maintainRecordVo.setLiftDept(maintainRecord.getLiftDept());
            maintainRecordVo.setRemark(maintainRecord.getRemark());
            maintainRecordVo.setMaintainResult(maintainRecord.getMaintainResult());
            maintainRecordVo.setMaintainRecordId(maintainRecord.getMaintainRecordId());
            maintainRecordVo.setMaintainDept(maintainRecord.getMaintainDept());
            maintainRecordVo.setMaintainDate(maintainRecord.getMaintainDate());
            //电梯类型 1-乘客电梯，2-载货电梯，3-液压电梯，4-杂物电梯，5-自动扶梯，6-自动人行道
            if (maintainRecord.getLiftType() != null) {
                switch (maintainRecord.getLiftType()) {
                    case 1:
                        maintainRecordVo.setLiftType("乘客电梯");
                        break;
                    case 2:
                        maintainRecordVo.setLiftType("载货电梯");
                        break;
                    case 3:
                        maintainRecordVo.setLiftType("液压电梯");
                        break;
                    case 4:
                        maintainRecordVo.setLiftType("杂物电梯");
                        break;
                    case 5:
                        maintainRecordVo.setLiftType("自动扶梯");
                        break;
                    case 6:
                        maintainRecordVo.setLiftType("自动人行道");
                        break;
                    default:
                        maintainRecordVo.setLiftType("Unknown lift type!");
                        break;
                }
            } else {
                maintainRecordVo.setLiftType("Unknown lift type!");
            }
            maintainRecordVoList.add(maintainRecordVo);
        }

        return maintainRecordVoList;
    }
}
