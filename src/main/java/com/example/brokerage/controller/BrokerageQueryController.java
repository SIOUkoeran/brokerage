package com.example.brokerage.controller;


import com.example.brokerage.entity.ActionType;
import com.example.brokerage.policy.BrokeragePolicy;
import com.example.brokerage.policy.BrokeragePolicyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class BrokerageQueryController {

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price){

        BrokeragePolicy brokeragePolicy =  BrokeragePolicyFactory.of(actionType);
        return brokeragePolicy.calculate(price);
    }
}