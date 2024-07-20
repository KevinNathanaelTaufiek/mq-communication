package com.kevinnathanaeltaufiek.mq_communication.listener;

import jakarta.jms.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestMqSubscriber {
    @JmsListener(destination = "SYSTEM.MANAGED.DURABLE.669BB6A422C2F701", id = "JMSCONTAINER-TEST.SUBS")
    public void consumeMsg(Message message){
        log.info("[TestMqSubscriber] Queue Listener got Message : {}", message);
    }
}
