package com.hjh.tio.server.activemqProducer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;
import java.io.IOException;

/**
 * @program: liftmanagement
 * @description: ${description}
 * @author: cdx
 * @create: 2018-07-22 15:42
 **/
public class ActivemqProducer {
    /**
     * ActiveMQ队列模式生产者
     * @throws JMSException
     */
    public void sendQueueProducer(String jsonString) throws JMSException {
        //1.创建一个连接工厂对象、需要指定IP和端口/消息服务端口为61616
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //2.使用连接工厂来创建连接
        Connection connection = connectionFactory.createConnection();
        //3.开启连接
        connection.start();
        //4.创建一个会话，
        //第一个参数为是否开启ActiveMQ的事务，一般不使用事务
        //如果开启事务，第二个参数自动忽略，不开启事务，第二个参数表示消息的应答模式，自动应答、手动应答
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.使用Session对象来创建一个Destination对象，topic或者queue
        Queue queue = session.createQueue("liftInfo-Queue");
        //6.使用Session对象来创建一个生产者
        MessageProducer producer = session.createProducer(queue);
        //7.创建一个TextMessage对象
        TextMessage textMessage = new ActiveMQTextMessage();
        textMessage.setText(jsonString);
        //8.发送消息
        producer.send(textMessage);
        //9.关闭资源
        producer.close();
        session.close();
        connection.close();
    }

    /**
     * ActiveMQ的订阅模式生产者
     */
    public void sendTopicProducer(String jsonString) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("liftInfo-Topic");
        MessageProducer producer = session.createProducer(topic);
        TextMessage activeMQ_topic = session.createTextMessage(jsonString);
        producer.send(activeMQ_topic);

        producer.close();
        session.close();
        connection.close();
    }
}
