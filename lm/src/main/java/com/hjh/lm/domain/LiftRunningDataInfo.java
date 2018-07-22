package com.hjh.lm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: liftmanagement
 * @description: ${description}
 * @author: cdx
 * @create: 2018-07-22 16:27
 * 电梯运行数据Repo
 **/
@Entity
public class LiftRunningDataInfo {
    // 电梯编号
    @Id
    @GeneratedValue
    private Long id;
    //    电梯编号
    private String liftId;
    //    当前时间戳
    private long timestamp;
    //    电梯高度
    private int height;
    //   电梯运行速度
    private int speed;
    //    电梯门是否打开,0-没有打开 1-打开
    private int door;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLiftId() {
        return liftId;
    }

    public void setLiftId(String liftId) {
        this.liftId = liftId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
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

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }
}

