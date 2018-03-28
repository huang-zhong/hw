package com.palpay.mq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

/**
 * <p>描述: 消息生产者 </p>
 * <p>@author huangzhong </p>
 * <p>创建时间: 2018/03/27 09:56 </p>
 * <p/>
 * <p>Copyright: 2013 - 2018 www.szwcyq.com Inc. All rights reserved. </p>
 * <p>注意：本内容仅限于深圳微创云启技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的</p>
 */
public class JMSProducerUtil {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Object event,Destination destination,SprayMessageConverter messageConverter) {
        jmsTemplate.setMessageConverter(messageConverter);
        jmsTemplate.setDefaultDestination(destination);
        jmsTemplate.convertAndSend(event);
    }
}
