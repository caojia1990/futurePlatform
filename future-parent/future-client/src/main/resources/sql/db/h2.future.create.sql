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

CREATE TABLE FUTURE_TICK(
    TRADING_DAY varchar(8),
    UPDATE_TIME varchar(8),
    UPDATE_MILLISECS int,
    LAST_PRICE double,
    BID_PRICE double,
    BID_VOLUME int,
    ASK_PRICE double,
    ASK_VOLUME int,
    VOLUME int,
    OPEN_INTEREST int,
    TURNOVER double
)

