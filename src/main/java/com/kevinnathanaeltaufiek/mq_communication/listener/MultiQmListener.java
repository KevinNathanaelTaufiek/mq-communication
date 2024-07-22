package com.kevinnathanaeltaufiek.mq_communication.listener;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MultiQmListener {
    private final String QUEUE_NAME = "MULTI.QM.QUEUE";

    @JmsListener(destination = QUEUE_NAME, containerFactory = "qm1JmsListenerContainerFactory")
    public void receive1(String text) {
        System.out.println("Received from qm1: " + text);
    }

    @JmsListener(destination = QUEUE_NAME, containerFactory = "qm2JmsListenerContainerFactory")
    public void receive2(String text) {
        System.out.println("Received from qm2: " + text);
    }
}
