package com.future.trade.api.vo;

public enum OrderPriceType {
    
    AnyPrice('1', "市价"),
    
    LimitPrice('2', "限价"),
    
    BestPrice('3', "最优价"),
    
    LastPrice('4', "最新价"),
    
    LastPricePlusOneTicks('5', "最新价加一跳"),
    
    LastPricePlusTwoTicks('6', "最新价加两跳"),
    
    LastPricePlusThreeTicks('7', "最新价加三跳"),
    
    AskPrice1('8', "卖一价"),
    
    AskPrice1PlusOneTicks('9', "卖一价加一跳"),
    
    AskPrice1PlusTwoTicks('A', "卖一价加两跳"),
    
    AskPrice1PlusThreeTicks('B', "卖一价加三跳"),
    
    BidPrice1('C', "买一价"),
    
    BidPrice1PlusOneTicks('D', "买一价加一跳"),
    
    BidPrice1PlusTwoTicks('E', "买一价加两跳"),
    
    BidPrice1PlusThreeTicks('F', "买一价加三跳");
    
    private char code;
    
    private String text;
    
    private OrderPriceType(char code, String text){
        this.code = code;
        this.text = text;
    }
    

    public char getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCode(char code) {
        this.code = code;
    }
    
    public static OrderPriceType ofCode(char code){
        for(OrderPriceType orderPriceType : OrderPriceType.values()){
          if(code == orderPriceType.getCode()){
            return orderPriceType;
          }
        }
        return null;  
    }

}
