package com.example.brokerage.policy;

import com.example.brokerage.entity.ActionType;


public class BrokeragePolicyFactory {

    public BrokeragePolicy of(ActionType actionType){
        switch (actionType){
            case RENT:
                return new RentBrokeragePolicy();
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            default:
                throw new IllegalArgumentException("지원하지 않는 유형입니다.");
        }
    }
}
