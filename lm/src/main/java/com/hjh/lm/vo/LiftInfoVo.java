package com.hjh.lm.vo;

/**
 * 接收从前端传送的查询条件
 */
public class LiftInfoVo {
    // 电梯编号
    private String liftId;
    // 紧急联系电话
    private String liftEmergencePhoneNumber;
    // 电梯所属单位
    private String liftAgent;

    public LiftInfoVo(String liftId, String liftEmergencePhoneNumber, String liftAgent) {
        this.liftId = liftId;
        this.liftEmergencePhoneNumber = liftEmergencePhoneNumber;
        this.liftAgent = liftAgent;
    }

    public String getLiftId() {
        return liftId;
    }

    public void setLiftId(String liftId) {
        this.liftId = liftId;
    }

    public String getLiftEmergencePhoneNumber() {
        return liftEmergencePhoneNumber;
    }

    public void setLiftEmergencePhoneNumber(String liftEmergencePhoneNumber) {
        this.liftEmergencePhoneNumber = liftEmergencePhoneNumber;
    }

    public String getLiftAgent() {
        return liftAgent;
    }

    public void setLiftAgent(String liftAgent) {
        this.liftAgent = liftAgent;
    }
}
