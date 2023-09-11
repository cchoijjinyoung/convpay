package com.study.convpay;

import com.study.convpay.dto.PayCancelRequest;
import com.study.convpay.dto.PayCancelResponse;
import com.study.convpay.dto.PayRequest;
import com.study.convpay.dto.PayResponse;
import com.study.convpay.service.ConveniencePayService;
import com.study.convpay.type.ConvenienceType;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편의점 결제 서비스 -> 머니

        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // 결제 1000원
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 1000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);
        System.out.println("payResponse = " + payResponse);
        // 취소 500원

        PayCancelRequest payCancelRequest = new PayCancelRequest(ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
        System.out.println("payCancelResponse = " + payCancelResponse);
    }
}
