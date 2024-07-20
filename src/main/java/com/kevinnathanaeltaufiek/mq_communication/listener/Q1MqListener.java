package com.kevinnathanaeltaufiek.mq_communication.listener;

import com.kevinnathanaeltaufiek.mq_communication.dto.TestDto;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Q1MqListener {
    @JmsListener(destination = "Q1.TO.DEV", id = "JMSCONTAINER-Q1.TO.DEV")
    public void consumeMsgDQ1(Message message) throws JMSException {
        log.info("[Q1MqListener] Queue Listener got Message : {}", message);
        log.info("[Q1MqListener] Queue Listener Custom Property : {}", message.getStringProperty("my_property"));
        log.info("[Q1MqListener] Queue Listener got DTO : {}", message.getBody(TestDto.class));
    }
}
