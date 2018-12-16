package org.tio.examples.showcase.common.packets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * tio客户端发送的电梯数据信息请求Body
 */
public class LiftInformationReqBody extends BaseBody {
    private static Logger log = LoggerFactory.getLogger(LiftInformationReqBody.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
    }

    private String liftId;
    private long timestamp;
    private int height;
    private int speed;
    private boolean door;

    /**
     * 无参构造方法
     */
    public LiftInformationReqBody() {
    }

    /**
     * 构造方法
     * @param liftId 设备ID
     * @param timestamp 时间戳
     * @param height 电梯高度
     * @param speed 电梯速度
     * @param door 电梯是否开门
     */
    public LiftInformationReqBody(String liftId, Long timestamp, int height, int speed, boolean door) {
        this.liftId = liftId;
        this.timestamp = timestamp;
        this.height = height;
        this.speed = speed;
        this.door = door;
    }

    public String getLiftId() {
        return liftId;
    }

    public void setLiftId(String liftId) {
        this.liftId = liftId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "LiftInformationReqBody{" +
                "liftId='" + liftId + '\'' +
                ", timestamp=" + timestamp +
                ", height=" + height +
                ", speed=" + speed +
                ", door=" + door +
                '}';
    }
}
