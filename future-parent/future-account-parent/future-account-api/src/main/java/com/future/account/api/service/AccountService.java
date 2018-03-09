package com.future.account.api.service;

import com.future.account.api.vo.FrozenCommissionParamVO;
import com.future.account.api.vo.FrozenMarginParamVO;

/**
 * 账户接口
 * @author caojia
 *
 */
public interface AccountService {
    
    /**
     * 创建账户
     * @param investorNo
     */
    public String createAccount(String investorNo);
    
    /**
     * 冻结手续费
     * @param paramVO
     */
    public void frozenCommission(FrozenCommissionParamVO paramVO);
    
    /**
     * 冻结保证金
     */
    public void frozenMargin(FrozenMarginParamVO paramVO);

}
