package com.study.convpay.service;

import com.study.convpay.dto.*;
import com.study.convpay.type.*;

public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter(); // 한 번 생성하면 바뀌면 안됨. final
    private final CardAdapter cardAdapter = new CardAdapter();
    //    private final DiscountInterface discountInterface = new DiscountByPayMethod();
    private final DiscountInterface discountInterface = new DiscountByConvenience();

    /**
     * 결제
     */
    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface;

        if (payRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }
        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
        PaymentResult paymentResult = paymentInterface.payment(discountedAmount);

        if (paymentResult == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }
        // 그래서 단 하나의 성공 케이스를 마지막에 한다.
        return new PayResponse(PayResult.SUCCESS, discountedAmount);
    }

    /**
     * 결제취소
     */
    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if (payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(
                payCancelRequest.getPayCancelAmount());
        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        // Success case
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
