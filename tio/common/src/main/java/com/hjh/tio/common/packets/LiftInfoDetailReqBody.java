package com.hjh.tio.common.packets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * tio客户端发送电梯详情request
 */
public class LiftInfoDetailReqBody extends BaseBody {
    private static Logger log = LoggerFactory.getLogger(LiftInfoDetailReqBody.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
    }

    private String liftId;
    private String produceCompany;
    private double prices;

    /**
     * 无参构造方法
     */
    public LiftInfoDetailReqBody() {
    }

    public LiftInfoDetailReqBody(String liftId, String produceCompany, double prices) {
        this.liftId = liftId;
        this.produceCompany = produceCompany;
        this.prices = prices;
    }

    public String getLiftId() {
        return liftId;
    }

    public void setLiftId(String liftId) {
        this.liftId = liftId;
    }

    public String getProduceCompany() {
        return produceCompany;
    }

    public void setProduceCompany(String produceCompany) {
        this.produceCompany = produceCompany;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "LiftInfoDetailReqBody{" +
                "liftId='" + liftId + '\'' +
                ", produceCompany='" + produceCompany + '\'' +
                ", prices=" + prices +
                '}';
    }
}
