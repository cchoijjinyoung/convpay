package com.study.convpay.service;

import com.study.convpay.dto.PayRequest;
import com.study.convpay.type.ConvenienceType;
import com.study.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
    DiscountByConvenience discountByConvenience = new DiscountByConvenience();
    @Test
    void discountTest() {
        // given
        PayRequest payRequestG25 = new PayRequest(ConvenienceType.G25, PayMethodType.MONEY, 1000);
        PayRequest payRequestGU = new PayRequest(ConvenienceType.GU, PayMethodType.MONEY, 1000);
        PayRequest payRequestSEVEN = new PayRequest(ConvenienceType.SEVEN, PayMethodType.MONEY, 1000);
        // when
        Integer discountedAmountG25 = discountByConvenience.getDiscountedAmount(payRequestG25);
        Integer discountedAmountGU = discountByConvenience.getDiscountedAmount(payRequestGU);
        Integer discountedAmountSEVEN = discountByConvenience.getDiscountedAmount(payRequestSEVEN);
        // then
        assertEquals(800, discountedAmountG25);
        assertEquals(900, discountedAmountGU);
        assertEquals(1000, discountedAmountSEVEN);
    }

}