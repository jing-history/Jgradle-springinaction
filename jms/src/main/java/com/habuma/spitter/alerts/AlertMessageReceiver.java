package com.habuma.spitter.alerts;

import com.habuma.spitter.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * Created by wangyunjing on 2016/11/4.
 */
@Component
public class AlertMessageReceiver {
    @Autowired
    JmsTemplate jmsTemplate;

    public Spittle getAlert() {
        try {
            ObjectMessage receivedMessage =
                    (ObjectMessage) jmsTemplate.receive(); //<co id="co_receive"/>

            return (Spittle) receivedMessage.getObject();//<co id="co_getObject"/>
        } catch (JMSException jmsException) {
            throw JmsUtils.convertJmsAccessException(jmsException);//<co id="co_throwException"/>
        }
    }
}
