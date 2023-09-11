package com.study.convpay.service;

import com.study.convpay.type.CancelPaymentResult;
import com.study.convpay.type.PaymentResult;

public interface PaymentInterface {
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount);
}
