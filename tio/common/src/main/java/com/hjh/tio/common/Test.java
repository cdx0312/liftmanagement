/**
 * @(#)Test.java, 三月 16, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hjh.tio.common;

import cn.hutool.json.JSONUtil;
import com.hjh.tio.common.packets.LiftInformationReqBody;
import org.tio.utils.json.Json;

import java.io.UnsupportedEncodingException;

/**
 * @author dxchang
 */
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        MyPacket packet = new MyPacket();
        packet.setType(Type.SEND_LIFTINFORMATION_REQ);
        packet.setTimestamp(System.currentTimeMillis());
        LiftInformationReqBody body = new LiftInformationReqBody();
        body.setDoor(true);
        body.setHeight(1);
        body.setLiftId("ddd");
        body.setSpeed(12);
        body.setTimestamp(1234L);
        packet.setBody(Json.toJson(body).getBytes(MyPacket.CHARSET));
        System.out.println(Json.toJson(packet));
    }
}