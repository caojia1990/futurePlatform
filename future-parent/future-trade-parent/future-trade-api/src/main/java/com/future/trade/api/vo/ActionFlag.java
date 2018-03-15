package com.future.trade.api.vo;

/**
 * 操作标志类型
 * @author caojia
 */
public enum ActionFlag {
    
    Delete('0', "撤单"),
    
    Modify('3', "改单");
    
    final char code;
    
    final String text;
    
    private ActionFlag(char code, String text){
        this.code = code;
        this.text = text;
    }

    public char getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
    
    public static ActionFlag ofCode(char code){
        for(ActionFlag actionFlag : ActionFlag.values()){
          if(code == actionFlag.getCode()){
            return actionFlag;
          }
        }
        return null;  
    }

}
