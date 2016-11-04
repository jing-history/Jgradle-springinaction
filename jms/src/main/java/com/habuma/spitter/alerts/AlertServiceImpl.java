package com.habuma.spitter.alerts;

import com.habuma.spitter.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by wangyunjing on 2016/11/4.
 */
public class AlertServiceImpl implements AlertService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public void sendSpittleAlert(final Spittle spittle) {
        jmsTemplate.send(new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createObjectMessage(spittle);
                    }
                });
    }
}
