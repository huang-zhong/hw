package com.palpay.mq.JMSConsumer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <p>描述: JMSCosumer </p>
 * <p>@author huangzhong </p>
 * <p>创建时间: 2018/03/27 10:41 </p>
 * <p/>
 * <p>Copyright: 2013 - 2018 www.szwcyq.com Inc. All rights reserved. </p>
 * <p>注意：本内容仅限于深圳微创云启技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的</p>
 */
public class JMSCosumerUtil {

    private static String BORKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    public static void main(String[] args){
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageConsumer messageConsumer;

        try {
            connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BORKER_URL);
            connection = connectionFactory.createConnection();
            session = connection.createSession();
            destination = session.createQueue("helloworld");
            messageConsumer = session.createConsumer(destination);

            while(true){
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                if(textMessage != null){
                    System.out.println("收到的消息：" + textMessage.getText());
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
