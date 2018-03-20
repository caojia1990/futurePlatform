package com.future.account.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.future.account.api.exception.AccountErrorMsg;
import com.future.account.api.exception.AccountException;
import com.future.account.api.service.AccountService;
import com.future.account.api.vo.AccountVO;
import com.future.account.service.utils.RedisLock;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @Autowired
    private ValueOperations<String, AccountVO> valueOperations;

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
        RedisLock lock = new RedisLock(redisTemplate, accountNo);
        try {
            if (lock.lock()) {
                
                String accountJsonStr = redisTemplate.opsForValue().get(accountNo);
                AccountVO accountVO = JSON.parseObject(accountJsonStr, AccountVO.class);
                BigDecimal available = accountVO.getAvailable();
                if(available.subtract(commision).subtract(margin).compareTo(BigDecimal.ZERO) < 0){
                    throw new AccountException(AccountErrorMsg.NoMoreMoney);
                }
            }
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

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
