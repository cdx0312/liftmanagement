package com.hjh.lm.domain;

import com.alibaba.fastjson.JSON;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 维修记录
 */
@Entity
public class FixRecord {
    @Id
    @GeneratedValue
    private Long fixRecordId;
    // 电梯编号
    private String liftId;
    // 报修时间
    private Date reportTime;
    // 故障原因
    private String crashReason;
    // 故障现象
    private String crashApperance;
    // 维修内容
    private String fixContent;
    // 是否更换零件
    private String isReplance;
    // 维修时间
    private Date fixDate;
    // 维修结果
    private String fixResult;

    public static void main(String[] args) {
        FixRecord fixRecord = new FixRecord();
        fixRecord.setLiftId("dafda");
        fixRecord.setFixContent("djfkaldjlkf");
        fixRecord.setCrashApperance("11");
        fixRecord.setCrashReason("11");
        fixRecord.setFixDate(new Date());
        fixRecord.setReportTime(new Date());
        fixRecord.setFixResult("11");
        fixRecord.setIsReplance("是");
        System.out.println(JSON.toJSONStringWithDateFormat(fixRecord, "yyyy-MM-dd"));
        System.out.println(new Date());
    }

    public Long getFixRecordId() {
        return fixRecordId;
    }

    public void setFixRecordId(Long fixRecordId) {
        this.fixRecordId = fixRecordId;
    }

    public String getLiftId() {
        return liftId;
    }

    public void setLiftId(String liftId) {
        this.liftId = liftId;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getCrashReason() {
        return crashReason;
    }

    public void setCrashReason(String crashReason) {
        this.crashReason = crashReason;
    }

    public String getCrashApperance() {
        return crashApperance;
    }

    public void setCrashApperance(String crashApperance) {
        this.crashApperance = crashApperance;
    }

    public String getFixContent() {
        return fixContent;
    }

    public void setFixContent(String fixContent) {
        this.fixContent = fixContent;
    }

    public String getIsReplance() {
        return isReplance;
    }

    public void setIsReplance(String isReplance) {
        this.isReplance = isReplance;
    }

    public Date getFixDate() {
        return fixDate;
    }

    public void setFixDate(Date fixDate) {
        this.fixDate = fixDate;
    }

    public String getFixResult() {
        return fixResult;
    }

    public void setFixResult(String fixResult) {
        this.fixResult = fixResult;
    }

    @Override
    public String toString() {
        return "FixRecord{" +
                "fixRecordId=" + fixRecordId +
                ", liftId='" + liftId + '\'' +
                ", reportTime=" + reportTime +
                ", crashReason='" + crashReason + '\'' +
                ", crashApperance='" + crashApperance + '\'' +
                ", fixContent='" + fixContent + '\'' +
                ", isReplance='" + isReplance + '\'' +
                ", fixDate=" + fixDate +
                ", fixResult='" + fixResult + '\'' +
                '}';
    }
}
