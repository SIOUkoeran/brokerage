package com.example.brokerage.policy;


/**
 * 가격이 특정 범위일 대 생산효율과 상환 금액
 */
public class BrokerageRule {
    private Double brokeragePercent;
    private Long limitAmount;

    public Long calcMaxBrokerage(Long price) {
        if (limitAmount == null){
            return multiplyPercent(price);
        }
        return Math.min(multiplyPercent(price),limitAmount);
    }

    private Long multiplyPercent(Long price){
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }
}
