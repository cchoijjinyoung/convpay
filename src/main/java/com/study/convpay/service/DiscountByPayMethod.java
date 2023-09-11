package com.study.convpay.service;

import com.study.convpay.dto.PayRequest;

public class DiscountByPayMethod implements DiscountInterface {
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        switch (payRequest.getPayMethodType()) {

            case CARD -> {
                return payRequest.getPayAmount();
            }
            case MONEY -> {
                return payRequest.getPayAmount() * 7 / 10;
            }
        }
        return payRequest.getPayAmount();
    }
}
