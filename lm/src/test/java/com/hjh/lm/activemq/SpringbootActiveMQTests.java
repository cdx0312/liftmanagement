package com.hjh.lm.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

/**
 * @program: liftmanagement
 * @description: ${description}
 * @author: cdx
 * @create: 2018-07-22 16:07
 * 测试集成的Activemq是否可用
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootActiveMQTests {
    @Autowired
    private Producer producer;

    @Test
    public void contextLoad() {
        Destination destination = new ActiveMQQueue("test-Queue");
        for (int i = 0; i < 100; i++) {
            producer.sendMessage(destination, "springboot activemq test!!!");
        }
    }
}
