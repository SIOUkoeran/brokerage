package com.example.brokerage.controller;


import com.example.brokerage.entity.ActionType;
import com.example.brokerage.policy.BrokeragePolicy;
import com.example.brokerage.policy.BrokeragePolicyFactory;
import com.example.brokerage.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BrokerageQueryController {

    private final ApartmentService apartmentService;
    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price){

        BrokeragePolicy brokeragePolicy =  BrokeragePolicyFactory.of(actionType);
        return brokeragePolicy.calculate(price);
    }

    @GetMapping("/api/calc/apartment/{apartmentId}")
    public Long calcBrokerageApartmentId(@PathVariable Long apartmentId,
                                         @RequestParam ActionType actionType){
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        Long price = this.apartmentService.getPrice(apartmentId);
        return policy.calculate(price);
    }
}