package com.future.trade.api.vo;

/**
 * 强平原因
 * @author caojia
 */
public enum ForceCloseReason {
    
    /**
     * 非强平 正常交易选这个
     */
    NotForceClose('0', "非强平"),
    
    /**
     * 资金不足
     */
    LackDeposit('1', "资金不足"),
    
    /**
     * 客户超仓
     */
    ClientOverPositionLimit('2', "客户超仓"),
    
    /**
     * 会员超仓
     */
    MemberOverPositionLimit('3', "会员超仓"),
    
    /**
     * 持仓非整倍数
     */
    NotMultiple('4', "持仓非整数倍"),
    
    /**
     * 违规
     */
    Violation('5', "违规"),
    
    /**
     * 其它
     */
    Other('6', "其他"),
    
    /**
     * 自然人临近交割
     */
    PersonDeliv('7', "自然人临近交割");
    
    final char code;
    
    final String text;
    
    private ForceCloseReason(char code, String text){
        this.code = code;
        this.text = text;
    }

    public char getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
    
    public static ForceCloseReason ofCode(char code){
        for(ForceCloseReason forceCloseReason : ForceCloseReason.values()){
          if(code == forceCloseReason.getCode()){
            return forceCloseReason;
          }
        }
        return null;  
    }
}
