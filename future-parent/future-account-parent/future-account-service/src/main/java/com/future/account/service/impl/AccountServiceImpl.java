package com.future.account.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.future.account.api.exception.AccountException;
import com.future.account.api.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Override
    public String createAccount(String investorNo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void frozenCommission(String investorNo, String accountNo, BigDecimal amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void thawCommission(String investorNo, String accountNo, BigDecimal amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void frozenCapital(String investorNo, String accountNo, BigDecimal commision, BigDecimal margin)
            throws AccountException {
        // TODO Auto-generated method stub

    }

    @Override
    public void deductCommission(String investorNo, String accountNo, BigDecimal amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void frozenMargin(String investorNo, String accountNo, BigDecimal amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void thawMargin(String investorNo, String accountNo, BigDecimal amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void occupyMargin(String investorNo, String accountNo, BigDecimal amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void releaseMargin(String investorNo, String accountNo, BigDecimal amount) {
        // TODO Auto-generated method stub

    }

}
