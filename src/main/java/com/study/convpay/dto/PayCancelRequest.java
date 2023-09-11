package com.study.convpay.dto;

import com.study.convpay.type.ConvenienceType;
import com.study.convpay.type.PayMethodType;

public class PayCancelRequest {
    // 편의점 종류
    ConvenienceType convenienceType;
    PayMethodType payMethodType;
    // 결제 취소 금액
    Integer payCancelAmount;

    public PayCancelRequest(ConvenienceType convenienceType, PayMethodType payMethodType, Integer payCancelAmount) {
        this.convenienceType = convenienceType;
        this.payMethodType = payMethodType;
        this.payCancelAmount = payCancelAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }
}
