package com.hjh.lm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 *报警短信记录
 * */
@Entity
public class AlertMessage {
    @Id
    @GeneratedValue
    private Long alertMessageId;
    // 报警手机号
    private String phoneNumber;
    //    发送时间
    private Date sendTime;
    //    发送短信者
    private String operator;
    //    发送内容
    private String content;
    //    报警编号，外键，与AlertEvent关联
    private Long alertEventId;

    public Long getAlertMessageId() {
        return alertMessageId;
    }

    public void setAlertMessageId(Long alertMessageId) {
        this.alertMessageId = alertMessageId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAlertEventId() {
        return alertEventId;
    }

    public void setAlertEventId(Long alertEventId) {
        this.alertEventId = alertEventId;
    }
}
