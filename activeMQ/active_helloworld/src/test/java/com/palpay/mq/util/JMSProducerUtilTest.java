package com.palpay.mq.util;

import com.szwcyq.d3p.common.test.MockMvcJunitBaseTest;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * <p>描述: 消息生产者 </p>
 * <p>@author huangzhong </p>
 * <p>创建时间: 2018/03/27 09:56 </p>
 * <p/>
 * <p>Copyright: 2013 - 2018 www.szwcyq.com Inc. All rights reserved. </p>
 * <p>注意：本内容仅限于深圳微创云启技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的</p>
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
public class JMSProducerUtilTest extends MockMvcJunitBaseTest{


    @Resource JmsMessagingTemplate jmsMessagingTemplate;

//    private Queue queue;

    @Before
    public void init(){
    }

    /**
     *
     * @param msg
     * @param destination
     * @param messageConverter
     */
    public void send(String msg,Destination destination,SprayMessageConverter messageConverter) {
       // jmsMessagingTemplate.setJmsMessageConverter(messageConverter);
      //  jmsMessagingTemplate.setDefaultDestination(destination);
       // jmsMessagingTemplate.convertAndSend(msg);
    }

    @Test
    public void send(){
        jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(),"MQ消息");
    }
}
