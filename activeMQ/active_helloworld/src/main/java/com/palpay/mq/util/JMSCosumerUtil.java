package com.palpay.mq.util;

import org.springframework.jms.annotation.JmsListener;

/**
 * <p>描述: JMSCosumer </p>
 * <p>@author huangzhong </p>
 * <p>创建时间: 2018/03/27 10:41 </p>
 * <p/>
 * <p>Copyright: 2013 - 2018 www.szwcyq.com Inc. All rights reserved. </p>
 * <p>注意：本内容仅限于深圳微创云启技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目的</p>
 */
public class JMSCosumerUtil {

    @JmsListener(destination = "SPRAY_TASK_EVENT_QUEUE")
    public void receiveMessage(String text) {
        System.out.println("消费了: <" + text + ">");
    }
}
