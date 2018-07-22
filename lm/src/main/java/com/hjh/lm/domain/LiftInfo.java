package com.hjh.lm.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 监控电梯基本信息
 */
@Entity
public class LiftInfo {
    //    电梯编号
    @Id
    private String liftId;
    //    电梯坐标(经度，维度)
    private String liftPostion;
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

    public String getLiftId() {
        return liftId;
    }

    public void setLiftId(String liftId) {
        this.liftId = liftId;
    }

    public String getLiftPostion() {
        return liftPostion;
    }

    public void setLiftPostion(String liftPostion) {
        this.liftPostion = liftPostion;
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
