package com.kevinnathanaeltaufiek.mq_communication.service;

import com.kevinnathanaeltaufiek.mq_communication.dto.TestDto;
import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MqCommunicationService {
    @Value("${ibm.mq.sendingQueueName}")
    String nameOfSendingQueue;

    @Value("${ibm.mq.receivingQueueName}")
    String nameOfReceivingQueue;

    private final ApplicationContext applicationContext;

    public String readMessageFromMq() throws JMSException {
        JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(nameOfReceivingQueue);
        assert textMessage != null;
        String stringFromQueue;
        try {
            stringFromQueue = textMessage.getText();
        } catch (JMSException e) {
            log.error(e.getMessage());
            throw e;
        }
        return stringFromQueue;
    }

    public void sendMessageToMQ(String mqString) throws JmsException {
        JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
        try {
            jmsTemplate.convertAndSend(nameOfSendingQueue, mqString);
        } catch (JmsException e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    public void sendTestDto(TestDto testDto) throws JmsException {
        JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
        try {
            jmsTemplate.convertAndSend(nameOfSendingQueue, testDto, msg -> {
                msg.setStringProperty("my_property", "my_value");
                return msg;
            });
        } catch (JmsException e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
