package com.study.convpay.service;

import com.study.convpay.dto.*;
import com.study.convpay.type.MoneyUseCancelResult;
import com.study.convpay.type.MoneyUseResult;
import com.study.convpay.type.PayCancelResult;
import com.study.convpay.type.PayResult;

public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter(); // 한 번 생성하면 바뀌면 안됨. final
    private final CardAdapter cardAdapter = new CardAdapter();

    /**
     * 결제
     */
    public PayResponse pay(PayRequest payRequest) {
        MoneyUseResult moneyUseResult =
                moneyAdapter.use(payRequest.getPayAmount());
        // FAIL일 경우에 여러개의 Exception case가 있을 수 있다.
        // SUCCESS case는 단, 하나
        if (moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }
        // 그래서 단 하나의 성공 케이스를 마지막에 한다.
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
    }

    /**
     * 결제취소
     */
    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(
                payCancelRequest.getPayCancelAmount());
        if (moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        // Success case
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
