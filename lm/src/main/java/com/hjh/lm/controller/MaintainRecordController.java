package com.hjh.lm.controller;

import com.hjh.lm.domain.FixRecord;
import com.hjh.lm.domain.MaintainRecord;
import com.hjh.lm.service.FixRecordService;
import com.hjh.lm.service.MaintainRecordService;
import com.hjh.lm.vo.LmResult;
import com.hjh.lm.vo.MaintainRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller，处理报警事件相关的web请求
 */
@Controller
public class MaintainRecordController {

    // 注入保养记录Service,采用构造器注入
    private final MaintainRecordService maintainRecordService;

    @Autowired
    public MaintainRecordController(MaintainRecordService maintainRecordService) {
        this.maintainRecordService = maintainRecordService;
    }

    /**
     * 存储前端传送的保养数据，字段会自动装载进入MaintainRecord中
     * @param maintainRecord 接收前端传送的保养数据的实体
     */
    @ResponseBody
    @RequestMapping(value = "/maintainregist", method = RequestMethod.POST)
    @CrossOrigin
    public LmResult saveMaintainRecord(MaintainRecord maintainRecord){
        maintainRecordService.save(maintainRecord);
        return new LmResult("200", "save the maintainRecord");
    }

    /**
     * 根据电梯编号，从数据库中获取保养记录列表
     * @param liftId 电梯编号
     * @return 保养记录列表，如果liftID为空，则返回全部维修记录
     */
    @RequestMapping(value = "/maintainregist", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin // 解决跨域
    public LmResult getMaintainRecordsByLiftId(String liftId){
        List<MaintainRecordVo> maintainRecordVoList = maintainRecordService.getMaintainRecordsByLiftId(liftId);
        LmResult lmResult;
        if (maintainRecordVoList != null && maintainRecordVoList.size() != 0) {
            lmResult = new LmResult("200", "get the maintainRecordList", maintainRecordVoList);
        } else {
            lmResult = new LmResult("200", "the maintainRecordList is empty");
        }
        return lmResult;
    }
}
