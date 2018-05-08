DROP TABLE IF EXISTS FUTURE_MARKET_DATA;
create table FUTURE_MARKET_DATA(
    INSTRUMENT_ID VARCHAR(10) not null,
    OPENP_RICE double,
    LAST_PRICE double,
    VOLUME int,
    OPEN_INTEREST int,
    BID_PRICE1 double,
    BID_VOLUME1 int,
    ASK_PRICE1 double,
    ASK_VOLUME1 int,
    HIGHEST_PRICE double,
    LOWEST_PRICE double,
    TRADING_DATE varchar(8),
    UPDATE_TIME varchar(10),
    UPDATE_MILLISEC int
);

DROP TABLE IF EXISTS FUTURE_QUOTA;
CREATE TABLE FUTURE_QUOTA(
    INSTRUMENT_ID VARCHAR(10) not null,
    HIGHEST_PRICE double,
    LOWEST_PRICE double,
    primary key (INSTRUMENT_ID)
);

DROP TABLE IF EXISTS FUTURE_TICK;
CREATE TABLE FUTURE_TICK(
    INSTRUMENT_ID varchar(10),
    LAST_PRICE double,
    BID_PRICE double,
    BID_VOLUME int,
    ASK_PRICE double,
    ASK_VOLUME int,
    VOLUME int,
    AVERAGE_VOLUME int,
    OPEN_INTEREST int,
    TURNOVER double,
    primary key (INSTRUMENT_ID)
);

CREATE TABLE FUTURE_TRADE(
    INVESTOR_ID varchar(10),
    ACCOUNT_NO varchar(10),
    INSTRUMENT_ID VARCHAR(10),
    ORDER_REF varchar(10),
    TRADE_ID varchar(16),
    DIRECTION varchar(1),
    ORDER_SYS_ID varchar(16),
    PRICE double,
    VOLUME int,
    TRADING_DAY varchar(8)
);