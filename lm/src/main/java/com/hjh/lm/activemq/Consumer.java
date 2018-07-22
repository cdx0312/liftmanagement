package com.hjh.lm.activemq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hjh.lm.domain.LiftRunningDataInfo;
import com.hjh.lm.service.LiftRunningDataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: liftmanagement
 * @description: ${description}
 * @author: cdx
 * @create: 2018-07-22 16:04
 **/
@Component
public class Consumer {

    /**
     * 注入电梯运行数据service
     */
    @Autowired
    private LiftRunningDataInfoService liftRunningDataInfoService;

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "liftInfo-Queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:"+text);
        LiftRunningDataInfo liftRunningDataInfo = parseJsonToEntity(text);
        liftRunningDataInfoService.save(liftRunningDataInfo);
    }

    private static LiftRunningDataInfo parseJsonToEntity(String jsonString) {
        JSONObject parse = (JSONObject) JSON.parse(jsonString);
        LiftRunningDataInfo liftRunningDataInfo = new LiftRunningDataInfo();
        liftRunningDataInfo.setLiftId(parse.getString("liftId"));
        liftRunningDataInfo.setSpeed(parse.getInteger("speed"));
        liftRunningDataInfo.setHeight(parse.getInteger("height"));
        liftRunningDataInfo.setTimestamp(parse.getLong("timestamp"));
        if (parse.getBoolean("door")) {
            liftRunningDataInfo.setDoor(1);
        } else {
            liftRunningDataInfo.setDoor(0);
        }
        return liftRunningDataInfo;
    }

    public static void main(String[] args) {
        String jsonString = "{\"door\":false,\"height\":225,\"liftId\":\"8e7e3e54b17648e094f7f6d74b63cff6\",\"speed\":-85,\"time\":1532250169474,\"timestamp\":1532250169474}";
        JSONObject parse = (JSONObject) JSON.parse(jsonString);
        LiftRunningDataInfo liftRunningDataInfo = new LiftRunningDataInfo();
        liftRunningDataInfo.setLiftId(parse.getString("liftId"));
        liftRunningDataInfo.setSpeed(parse.getInteger("speed"));
        liftRunningDataInfo.setHeight(parse.getInteger("height"));
        liftRunningDataInfo.setTimestamp(parse.getLong("timestamp"));
        if (parse.getBoolean("door")) {
            liftRunningDataInfo.setDoor(1);
        } else {
            liftRunningDataInfo.setDoor(0);
        }
        System.out.println(liftRunningDataInfo.getHeight());
        System.out.println(liftRunningDataInfo.getDoor());
        System.out.println(liftRunningDataInfo.getTimestamp());
        System.out.println(liftRunningDataInfo.getSpeed());
        System.out.println(liftRunningDataInfo.getLiftId());
    }
}
