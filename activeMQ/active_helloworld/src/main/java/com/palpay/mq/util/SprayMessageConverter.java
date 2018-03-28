package com.palpay.mq.util;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * <p>描述: 消息装换器 </p>
 * <p>@author huangzhong </p>
 * <p>创建时间: 2018/03/28 14:48 </p>
 * <p/>
 * <p>Copyright: 2013 - 2018 www.szwcyq.com Inc. All rights reserved. </p>
 * <p>注意：本内容仅限于深圳微创云启技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的</p>
 */
@Component
public class SprayMessageConverter implements MessageConverter {
    @Override
    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
        Assert.notNull(o);
        TextMessage message = session.createTextMessage();
        if(o instanceof String){
            message.setStringProperty("event", (String) o);
            message.setText((String) o);
        }
        return message;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        return message;
    }
}
