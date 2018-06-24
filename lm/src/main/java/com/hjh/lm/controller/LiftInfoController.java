package com.hjh.lm.controller;

import com.hjh.lm.domain.LiftInfo;
import com.hjh.lm.domain.MaintainRecord;
import com.hjh.lm.service.LiftInfoService;
import com.hjh.lm.vo.LiftInfoPositions;
import com.hjh.lm.vo.LiftInfoVo;
import com.hjh.lm.vo.LmResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller，处理报警事件相关的web请求
 */
@Controller
public class LiftInfoController {

    // 注入电梯设备信息Service,采用构造器注入
    private LiftInfoService liftInfoService;

    public LiftInfoController(LiftInfoService liftInfoService) {
        this.liftInfoService = liftInfoService;
    }


    /**
     * 存储前端传送的数据设备信息数据，字段会自动装载进入liftInfo中
     * @param liftInfo 接收前端传送的设备信息数据的实体
     */
    @ResponseBody
    @RequestMapping(value = "/liftinfo/save", method = RequestMethod.POST)
    @CrossOrigin
    public LmResult saveLiftInfo(LiftInfo liftInfo){
        liftInfoService.save(liftInfo);
        return new LmResult("200", "save the liftInfo!");
    }

    /**
     * 根据查询条件，从数据库中获取设备数据记录列表
     * @param liftInfoVo 查询条件
     * @return 电梯设备信息，如果查询条件均为空，则返回全部设备记录
     */
    @RequestMapping(value = "/liftinfo/get", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin // 解决跨域
    public LmResult getLiftInfoByLiftInfoVo(LiftInfoVo liftInfoVo){
        List<LiftInfo> liftInfoList = liftInfoService.getAllLiftInfos(liftInfoVo);
        LmResult lmResult;
        if (liftInfoList != null && liftInfoList.size() != 0) {
            lmResult = new LmResult("200", "get the liftInfoList", liftInfoList);
        } else {
            lmResult = new LmResult("200", "the liftInfoList is empty");
        }
        return lmResult;
    }

    /**
     * 获取所有电梯设备的经纬度
     * @return 返回LmResult
     */
    @RequestMapping(value = "/liftinfo/getLiftPosition", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin // 解决跨域
    public LmResult getLiftPositions(){
        List<LiftInfo> liftInfoList = liftInfoService.getAllLiftInfos(new LiftInfoVo(null, null, null));
        LmResult lmResult;
        // 将liftInfoList中的坐标重写为两个，存入liftPosInfoList中
        List<LiftInfoPositions> liftPosInfoList = new ArrayList<>();
        for (LiftInfo liftInfo : liftInfoList) {
            LiftInfoPositions liftInfoPosition = new LiftInfoPositions(liftInfo);
            liftPosInfoList.add(liftInfoPosition);
        }
        if (liftPosInfoList != null && liftPosInfoList.size() != 0) {
            lmResult = new LmResult("200", "get the liftInfoList", liftPosInfoList);
        } else {
            lmResult = new LmResult("200", "the liftInfoList is empty");
        }
        return lmResult;
    }

    /**
     * 根据电梯ID删除ID
     * @param liftId 电梯ID
     * @return LmResult
     */
    @RequestMapping(value = "/liftinfo/removeLiftByLiftId", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin // 解决跨域
    public LmResult removeLiftByLiftId(String liftId) {
        liftInfoService.removeLiftByLiftId(liftId);
        return new LmResult("200", "remove the lift on the database");
    }

}
