package com.david.computationheavybackendapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;

@Controller
//@Scope("request")
public class TakeSomeTimeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TakeSomeTimeController.class);

    @RequestMapping(value = "/takeSomeTime", produces = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<String> takeSomeTime(
            @RequestBody String requestId
    ) throws InterruptedException {
        int waitTime = new Random().nextInt(5000);
        LOGGER.info("Relaxing for {}ms", waitTime);
        Thread.sleep(waitTime);
        return new ResponseEntity<>(requestId + " : " + waitTime, HttpStatus.OK);
    }
}
