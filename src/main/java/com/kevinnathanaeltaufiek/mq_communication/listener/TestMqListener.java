package com.kevinnathanaeltaufiek.mq_communication.listener;

import jakarta.jms.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestMqListener {
//    @JmsListener(destination = "TEST.TO.DEV", id = "JMSCONTAINER-TEST.TO.DEVstr")
//    public void consumeMsg(String message){
//       log.info("[TestMqListener] Queue Listener got Message : {}", message);
//    }

    // containerFactory bisa dihapus jika ga pakai multiple qm
    @JmsListener(destination = "TEST.TO.DEV", id = "JMSCONTAINER-TEST.TO.DEV", containerFactory = "qm1JmsListenerContainerFactory")
    public void consumeMsg(Message message){
        log.info("[TestMqListener] Queue Listener got Message : {}", message);
    }
}
