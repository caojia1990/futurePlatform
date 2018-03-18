DROP TABLE IF EXISTS FUTURE_ORDER_INPUT;

create table FUTURE_ORDER_INPUT(
    ORDER_REF VARCHAR(10) not null,
    INVESTOR_ID varchar(10),
    ACCOUNT_NO varchar(20),
    VOLUME_TOTAL_ORIGINAL int,
    TRADE_VOLUME int,
    FROZEN_COMMISSION double,
    FROZEN_MARGIN double,
    primary key (ORDER_REF)
);