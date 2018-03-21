package com.future.account.service.impl;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.future.account.api.exception.AccountErrorMsg;
import com.future.account.api.exception.AccountException;
import com.future.account.api.service.AccountService;
import com.future.account.api.vo.AccountVO;
import com.future.account.service.utils.AccountGenerateUtil;
import com.future.account.service.utils.RedisLock;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	static Logger logger = Logger.getLogger(AccountServiceImpl.class);
	
	static final String ACCOUNT_SEQ_KEY_SUFFIX = "-account-Seq-Key";
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @Autowired
    private ValueOperations<String, AccountVO> valueOperations;

    @Override
    public String createAccount(String investorNo) throws AccountException {

        Long seq = valueOperations.increment(investorNo+ACCOUNT_SEQ_KEY_SUFFIX, 1);
        String accounNo = AccountGenerateUtil.generateAccountNo(investorNo, seq);
        AccountVO accountVO = new AccountVO();
        accountVO.setAccountNo(accounNo);
        accountVO.setInvestorNo(investorNo);
        this.valueOperations.set(accounNo, accountVO);
        return accounNo;
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

        RedisLock lock = new RedisLock(redisTemplate, accountNo);
        try {
            if (lock.lock()) {
                
                AccountVO accountVO = this.valueOperations.get(accountNo);
                BigDecimal available = accountVO.getAvailable();
                if(available.subtract(commision).subtract(margin).compareTo(BigDecimal.ZERO) < 0){
                    throw new AccountException(AccountErrorMsg.NoMoreMoney);
                }
                accountVO.setFrozenCommission(accountVO.getFrozenCommission().add(commision));
                accountVO.setFrozenMargin(accountVO.getFrozenMargin().add(margin));
                this.valueOperations.set(accountNo, accountVO);
            }
            
        } catch (Exception e) {
            if(e instanceof AccountException) {
                throw (AccountException)e;
            }
            logger.error("冻结资金异常", e);
            throw new AccountException(AccountErrorMsg.UnexpectedError, e);
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

	@Override
	public void thawCapital(String investorNo, String accountNo, BigDecimal commission, BigDecimal margin)
			throws AccountException {

	    RedisLock lock = new RedisLock(redisTemplate, accountNo);
        try {
            if (lock.lock()) {
                AccountVO accountVO = this.valueOperations.get(accountNo);
                //释放手续费
                accountVO.setFrozenCommission(accountVO.getFrozenCommission().subtract(commission));
                //释放保证金
                accountVO.setFrozenMargin(accountVO.getFrozenMargin().subtract(margin));
                this.valueOperations.set(accountNo, accountVO);
            }
            
        } catch (Exception e) {
            logger.error("冻结资金异常", e);
            throw new AccountException(AccountErrorMsg.UnexpectedError, e);
        } finally {
            lock.unlock();
        }
        
	}

	@Override
	public void thawThenDeductAndOccupy(String investorNo, String accountNo, BigDecimal thrawCommission,
			BigDecimal thrawMargin, BigDecimal DeductCommission, BigDecimal occupyMargin) throws AccountException {

        RedisLock lock = new RedisLock(redisTemplate, accountNo);
        try {
            if (lock.lock()) {
                AccountVO accountVO = this.valueOperations.get(accountNo);
                //释放手续费
                accountVO.setFrozenCommission(accountVO.getFrozenCommission().subtract(thrawCommission));
                //释放保证金
                accountVO.setFrozenMargin(accountVO.getFrozenMargin().subtract(thrawMargin));
                //扣除手续费
                accountVO.setCommission(accountVO.getCommission().add(DeductCommission));
                //占用保证金
                accountVO.setCurrMargin(accountVO.getCurrMargin().add(occupyMargin));
                this.valueOperations.set(accountNo, accountVO);
            }
            
        } catch (Exception e) {
            logger.error("冻结资金异常", e);
            throw new AccountException(AccountErrorMsg.UnexpectedError, e);
        } finally {
            lock.unlock();
        }
		
	}

}
