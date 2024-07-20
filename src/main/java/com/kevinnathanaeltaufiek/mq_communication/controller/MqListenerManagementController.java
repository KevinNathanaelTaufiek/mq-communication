package com.kevinnathanaeltaufiek.mq_communication.controller;

import com.kevinnathanaeltaufiek.mq_communication.service.MqListenerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/listener")
public class MqListenerManagementController {

    @Autowired
    private MqListenerManagementService mqListenerManagementService;

    @PostMapping(value = "/start-all")
    public void startAll() {
        mqListenerManagementService.startAll();
    }

    @PostMapping(value = "/stop-all")
    public void stopAll() {
        mqListenerManagementService.stopAll();
    }

    @PostMapping(value = "/start/{containerId}")
    public void start(@PathVariable("containerId") String containerId) {
        mqListenerManagementService.start(containerId);
    }

    @PostMapping(value = "/stop/{containerId}")
    public void stop(@PathVariable("containerId") String containerId) {
        mqListenerManagementService.stop(containerId);
    }
}
