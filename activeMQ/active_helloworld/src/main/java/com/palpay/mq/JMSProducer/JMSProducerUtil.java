package com.palpay.mq.JMSProducer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <p>描述: 消息生产者 </p>
 * <p>@author huangzhong </p>
 * <p>创建时间: 2018/03/27 09:56 </p>
 * <p/>
 * <p>Copyright: 2013 - 2018 www.szwcyq.com Inc. All rights reserved. </p>
 * <p>注意：本内容仅限于深圳微创云启技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的</p>
 */
public class JMSProducerUtil {

    private static String BORKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;



    public static void main(String args[]){
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageProducer messageProducer;

        try {
            //初始化
            connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BORKER_URL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession();
            destination = session.createQueue("helloworld");
            messageProducer = session.createProducer(destination);
            sendMessage(session,messageProducer);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }

    /**
     * 发送消息
     * @param session
     * @param messageProducer
     */
    private static void sendMessage(Session session, MessageProducer messageProducer) {
        try {
            TextMessage message = session.createTextMessage("ActiveMQ 发送消息");
            messageProducer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
