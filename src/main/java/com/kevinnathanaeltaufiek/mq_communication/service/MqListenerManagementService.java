package com.kevinnathanaeltaufiek.mq_communication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MqListenerManagementService {

    @Autowired
    private JmsListenerEndpointRegistry jmsListenerEndpointRegistry;

    public void startAll() {
        log.info("[MqListenerManagementService] Start All Listener");
        jmsListenerEndpointRegistry.start();
    }

    public void stopAll() {
        log.info("[MqListenerManagementService] Stop All Listener");
        jmsListenerEndpointRegistry.stop();
    }

    public void start(String containerId) {
        log.info("[MqListenerManagementService] Start Listener with ID {}", containerId);
        MessageListenerContainer messageListenerContainer = jmsListenerEndpointRegistry.getListenerContainer(containerId);
        if (null == messageListenerContainer) {
            log.warn("[MqListenerManagementService] There is no Container with ID {}", containerId);
            return;
        }
        messageListenerContainer.start();
    }

    public void stop(String containerId) {
        log.info("[MqListenerManagementService] Stop Listener with ID {}", containerId);
        MessageListenerContainer messageListenerContainer = jmsListenerEndpointRegistry.getListenerContainer(containerId);
        if (null == messageListenerContainer) {
            log.warn("[MqListenerManagementService] There is no Container with ID {}", containerId);
            return;
        }
        messageListenerContainer.stop();

    }
}
