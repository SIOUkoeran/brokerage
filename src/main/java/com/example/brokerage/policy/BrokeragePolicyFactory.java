package com.example.brokerage.policy;

import com.example.brokerage.entity.ActionType;
import com.example.brokerage.exception.ErrorCode;
import com.example.brokerage.exception.HouseUtilsException;


public class BrokeragePolicyFactory {

    public static BrokeragePolicy of(ActionType actionType){
        switch (actionType){
            case RENT:
                return new RentBrokeragePolicy();
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            default:
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "잘못된 정책 요청입니다.");
        }
    }
}
