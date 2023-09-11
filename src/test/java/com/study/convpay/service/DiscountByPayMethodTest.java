package com.study.convpay.service;

import com.study.convpay.dto.PayRequest;
import com.study.convpay.type.ConvenienceType;
import com.study.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {

    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

    @Test
    void discountSuccess() {
        // given
        PayRequest payRequestMoney = new PayRequest(ConvenienceType.G25,
                PayMethodType.MONEY, 1000);
        PayRequest payRequestCard = new PayRequest(ConvenienceType.G25,
                PayMethodType.CARD, 1000);
        // when
        Integer discountedAmountMoney =
                discountByPayMethod.getDiscountedAmount(payRequestMoney);

        Integer discountedAmountCard =
                discountByPayMethod.getDiscountedAmount(payRequestCard);
        // then
        assertEquals(700, discountedAmountMoney);
        assertEquals(1000, discountedAmountCard);
    }

}