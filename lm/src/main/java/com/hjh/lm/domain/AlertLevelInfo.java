package com.hjh.lm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * 报警级别信息
 */
@Entity
public class AlertLevelInfo {
    @Id
    @GeneratedValue
    private Long alertLevelInfoId;
    // 报警级别 1-primary 2-senior 3-high
    private Integer alertLevel;
    // 报警类型列表 逗号分隔
    private String alertTypes;
    // 报警方式
    private String alertMethod;
    // 短信报警电话短信
    private String messageAlertPhoneNumber;
    // 报警联系人
    private String messageAlertHandlerMan;

    public Long getAlertLevelInfoId() {
        return alertLevelInfoId;
    }

    public void setAlertLevelInfoId(Long alertLevelInfoId) {
        this.alertLevelInfoId = alertLevelInfoId;
    }

    public Integer getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(Integer alertLevel) {
        this.alertLevel = alertLevel;
    }

    public String getAlertTypes() {
        return alertTypes;
    }

    public void setAlertTypes(String alertTypes) {
        this.alertTypes = alertTypes;
    }

    public String getAlertMethod() {
        return alertMethod;
    }

    public void setAlertMethod(String alertMethod) {
        this.alertMethod = alertMethod;
    }

    public String getMessageAlertPhoneNumber() {
        return messageAlertPhoneNumber;
    }

    public void setMessageAlertPhoneNumber(String messageAlertPhoneNumber) {
        this.messageAlertPhoneNumber = messageAlertPhoneNumber;
    }

    public String getMessageAlertHandlerMan() {
        return messageAlertHandlerMan;
    }

    public void setMessageAlertHandlerMan(String messageAlertHandlerMan) {
        this.messageAlertHandlerMan = messageAlertHandlerMan;
    }
}
