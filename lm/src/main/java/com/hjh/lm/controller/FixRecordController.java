package com.hjh.lm.controller;

import com.hjh.lm.domain.AlertEvent;
import com.hjh.lm.domain.FixRecord;
import com.hjh.lm.service.FixRecordService;
import com.hjh.lm.vo.LmResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Controller，处理报警事件相关的web请求
 */
@Controller
public class FixRecordController {

    // 注入报警事件Service,采用构造器注入
    private final FixRecordService fixRecordService;

    @Autowired
    public FixRecordController(FixRecordService fixRecordService) {
        this.fixRecordService = fixRecordService;
    }

    /**
     * 存储前端传送的维修数据，字段会自动装载进入fixRecord中
     * @param fixRecord 接收前端传送的维修数据的实体
     */
    @ResponseBody
    @RequestMapping(value = "/repairRecord/save" ,method=RequestMethod.POST)
    @CrossOrigin
    public LmResult saveFixRecord(FixRecord fixRecord){
        System.out.println("Entering saveFixRecord controller");
        System.out.println(fixRecord.toString());
        LmResult lmResult = new LmResult("200", "add the fixRecord", fixRecord);
        fixRecordService.save(fixRecord);
        System.out.println("leaving saveFixRecord controller");
        return lmResult;
    }

    /**
     * 根据电梯编号，从数据库中获取维修记录列表
     * @param liftId 电梯编号
     * @return 维修记录列表，如果liftID为空，则返回全部维修记录
     */
    @RequestMapping(value = "/repairRecord/get", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin // 解决跨域
    public LmResult getFixRecordsByLiftId(@Param("liftid") String liftId){
        List<FixRecord> fixRecordList = fixRecordService.getFixRecordsByLiftId(liftId);
        LmResult lmResult;
        if (fixRecordList != null && fixRecordList.size() != 0) {
            lmResult = new LmResult("200", "get the fixRecordList", fixRecordList);
        } else {
            lmResult = new LmResult("200", "the fixRecorList is empty");
        }
        return lmResult;
    }
}
