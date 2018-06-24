package com.hjh.lm.vo;

import com.hjh.lm.domain.LiftInfo;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Id;
import java.util.Date;

/**
 * 电梯数据信息，经纬度分开为两个字符串，在getLiftPostions方法中使用
 */
public class LiftInfoPositions {
    //    电梯编号
    private String liftId;
    //    电梯坐标(经度)
    private String lng;
    //    电梯坐标(维度)
    private String lat;
    //    电梯类型 1-乘客电梯，2-载货电梯，3-液压电梯，4-杂物电梯，5-自动扶梯，6-自动人行道
    private Integer liftType;
    //    电梯安装地址，省市区
    private String liftAddress;
    //    紧急联系人
    private String liftEmergenceHandleMan;
    //    紧急联系人电话
    private String liftEmergencePhoneNumber;
    //    每天启动时间
    private Date startTime;
    //    每天电梯停止时间
    private Date endTime;
    //    使用单位
    private String liftAgent;
    //    群组，属于使用单位的哪个群组
    private String liftGroupAgence;

    // 通过构造方法将liftInfo的数据导入
    public LiftInfoPositions(LiftInfo liftInfo) {
        this.liftId = liftInfo.getLiftId();
        this.liftAddress = liftInfo.getLiftAddress();
        this.endTime = liftInfo.getEndTime();
        this.liftAgent = liftInfo.getLiftAgent();
        this.liftEmergenceHandleMan = liftInfo.getLiftEmergenceHandleMan();
        this.liftEmergencePhoneNumber = liftInfo.getLiftEmergencePhoneNumber();
        this.liftGroupAgence = liftInfo.getLiftGroupAgence();
        this.liftType = liftInfo.getLiftType();
        this.startTime = liftInfo.getStartTime();
        String position = liftInfo.getLiftPostion();
        if (StringUtils.isNotBlank(position)) {
            String[] positions = position
                    .substring(1, liftInfo.getLiftPostion().length()-1).split(",");
            this.lng = positions[0];
            this.lat = positions[1];
        } else {
            this.lng = "0";
            this.lat = "0";
        }
    }

    public String getLiftId() {
        return liftId;
    }

    public void setLiftId(String liftId) {
        this.liftId = liftId;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Integer getLiftType() {
        return liftType;
    }

    public void setLiftType(Integer liftType) {
        this.liftType = liftType;
    }

    public String getLiftAddress() {
        return liftAddress;
    }

    public void setLiftAddress(String liftAddress) {
        this.liftAddress = liftAddress;
    }

    public String getLiftEmergenceHandleMan() {
        return liftEmergenceHandleMan;
    }

    public void setLiftEmergenceHandleMan(String liftEmergenceHandleMan) {
        this.liftEmergenceHandleMan = liftEmergenceHandleMan;
    }

    public String getLiftEmergencePhoneNumber() {
        return liftEmergencePhoneNumber;
    }

    public void setLiftEmergencePhoneNumber(String liftEmergencePhoneNumber) {
        this.liftEmergencePhoneNumber = liftEmergencePhoneNumber;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLiftAgent() {
        return liftAgent;
    }

    public void setLiftAgent(String liftAgent) {
        this.liftAgent = liftAgent;
    }

    public String getLiftGroupAgence() {
        return liftGroupAgence;
    }

    public void setLiftGroupAgence(String liftGroupAgence) {
        this.liftGroupAgence = liftGroupAgence;
    }
}
