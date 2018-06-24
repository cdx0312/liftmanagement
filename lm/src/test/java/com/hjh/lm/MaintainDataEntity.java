package com.hjh.lm;

/*
    {
      "liftid": "65",
      "lifttype": "fgd",
      "nextdate": "",
      "maintainresult": "",
      "securitythreat": "gdsg",
      "remark": "",
      "id": 1
    },
*/

import java.util.Date;

public class MaintainDataEntity {
    // 主键ID
    public String id;
//    电梯编号
    public String liftid;
//    保养时间
    public Date cdate;
//    保养结果
    public String maintainresult;
//    备注
    public String remark;

    public MaintainDataEntity(String id, String liftid, Date cdate, String maintainresult, String remark) {
        this.id = id;
        this.liftid = liftid;
        this.cdate = cdate;
        this.maintainresult = maintainresult;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLiftid() {
        return liftid;
    }

    public void setLiftid(String liftid) {
        this.liftid = liftid;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getMaintainresult() {
        return maintainresult;
    }

    public void setMaintainresult(String maintainresult) {
        this.maintainresult = maintainresult;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
