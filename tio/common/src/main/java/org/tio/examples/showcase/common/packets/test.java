package org.tio.examples.showcase.common.packets;

import java.util.UUID;

public class test {
    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(getUUID32());
    }
}
