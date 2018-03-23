DROP TABLE IF EXISTS FUTURE_ORDER_INPUT;
create table FUTURE_ORDER_INPUT(
    ORDER_REF VARCHAR(10) not null,
    INVESTOR_ID varchar(10),
    ACCOUNT_NO varchar(20),
    VOLUME_TOTAL_ORIGINAL int,
    TRADE_VOLUME int,
    FROZEN_COMMISSION double,
    FROZEN_MARGIN double,
    COMMISSION_EACH_HAND double,
    MARGIN_EACH_HAND double,
    primary key (ORDER_REF)
);

DROP TABLE IF EXISTS FUTURE_INVESTOR_POSITION;
create table FUTURE_INVESTOR_POSITION(
    INSTRUMENT_ID varchar(16) not null,
    INVESTOR_ID varchar(10),
    ACCOUNT_NO varchar(20),
    POSI_DIRECTION char,
    HEDGE_FLAG char,
    YD_POSITION int,
    POSITION int,
    YD_POSITION_FROZEN int,
    POSITION_FROZEN int,
    OPEN_VOLUME int,
    CLOSE_VOLUME int,
    OPEN_AMOUNT double,
    POSITION_COST double,
    PRE_MARGIN double,
    USE_MARGIN double,
    FROZEN_COMMISSION double,
    COMMISSION double,
    CLOSE_PROFIT double,
    POSITION_PROFIT double,
    PRE_SETTLEMENT_PRICE double,
    SETTLEMENT_PRICE double,
    TRADING_DAY varchar(8),
    SETTLEMENT_ID varchar(16)
);

DROP TABLE IF EXISTS FUTURE_INVESTOR_POSI_DETAIL;
create table FUTURE_INVESTOR_POSI_DETAIL(
    INSTRUMENT_ID varchar(16) not null,
    INVESTOR_ID varchar(10),
    ACCOUNT_NO varchar(20),
    HEDGE_FLAG char,
    DIRECTION char,
    OPEN_DATE varchar(8),
    TRADE_ID varchar(16),
    VOLUME int,
    OPEN_PRICE double,
    TRADING_DAY varchar(8),
    SETTLEMENT_ID varchar(16),
    TRADE_TYPE char,
    COMB_INSTRUMENT_ID varchar(20)
);