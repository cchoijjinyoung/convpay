package com.study.convpay.dto;

import com.study.convpay.type.ConvenienceType;
import com.study.convpay.type.PayMethodType;

public class PayRequest {
    // 편의점 종류
    ConvenienceType convenienceType;
    PayMethodType payMethodType;

    // 결제 금액
    Integer payAmount;

    public PayRequest(ConvenienceType convenienceType, PayMethodType payMethodType, Integer payAmount) {
        this.convenienceType = convenienceType;
        this.payMethodType = payMethodType;
        this.payAmount = payAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }
}
