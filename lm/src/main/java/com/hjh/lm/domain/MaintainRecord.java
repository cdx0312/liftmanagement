package com.hjh.lm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 保养记录
 */
@Entity
public class MaintainRecord {
    @Id
    @GeneratedValue
    private Long maintainRecordId;
    // 电梯编号
    private String liftId;
    // 保养日期
    private Date maintainDate;
    //    电梯类型 1-乘客电梯，2-载货电梯，3-液压电梯，4-杂物电梯，5-自动扶梯，6-自动人行道
    private Integer liftType;
    // 安全隐患备注
    private String remark;
    // 保养单位
    private String maintainDept;
    // 保养结果
    private String maintainResult;
    // 使用单位
    private String liftDept;

    public String getLiftDept() {
        return liftDept;
    }

    public void setLiftDept(String liftDept) {
        this.liftDept = liftDept;
    }

    public String getMaintainDept() {
        return maintainDept;
    }

    public void setMaintainDept(String maintainDept) {
        this.maintainDept = maintainDept;
    }

    public String getMaintainResult() {
        return maintainResult;
    }

    public void setMaintainResult(String maintainResult) {
        this.maintainResult = maintainResult;
    }

    public Long getMaintainRecordId() {
        return maintainRecordId;
    }

    public void setMaintainRecordId(Long maintainRecordId) {
        this.maintainRecordId = maintainRecordId;
    }

    public String getLiftId() {
        return liftId;
    }

    public void setLiftId(String liftId) {
        this.liftId = liftId;
    }

    public Date getMaintainDate() {
        return maintainDate;
    }

    public void setMaintainDate(Date maintainDate) {
        this.maintainDate = maintainDate;
    }

    public Integer getLiftType() {
        return liftType;
    }

    public void setLiftType(Integer liftType) {
        this.liftType = liftType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
