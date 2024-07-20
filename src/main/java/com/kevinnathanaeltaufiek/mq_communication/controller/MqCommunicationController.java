package com.kevinnathanaeltaufiek.mq_communication.controller;

import com.kevinnathanaeltaufiek.mq_communication.dto.TestDto;
import com.kevinnathanaeltaufiek.mq_communication.service.MqCommunicationService;
import jakarta.jms.JMSException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MqCommunicationController {

    private final MqCommunicationService mqCommunicationService;

    @GetMapping("save")
    public void saveStringInMq(@RequestBody String stringToSaveInMq){
        mqCommunicationService.sendMessageToMQ(stringToSaveInMq);
    }

    @GetMapping("read")
    public String readStringFromMQ() throws JMSException {
        return mqCommunicationService.readMessageFromMq();
    }

    @PostMapping("send-obj")
    public void saveStringInMq(@RequestBody TestDto testDto){
        mqCommunicationService.sendTestDto(testDto);
    }
}
